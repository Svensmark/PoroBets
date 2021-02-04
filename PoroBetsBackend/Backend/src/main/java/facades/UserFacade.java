package facades;

import entities.Role;
import entities.User;
import entities.dto.UserDTO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import errorhandling.AuthenticationException;
import errorhandling.ExistingUserException;
import javax.persistence.TypedQuery;

/**
 * @author lam@cphbusiness.dk
 */
public class UserFacade {
  
    private static EntityManagerFactory emf;
    private static UserFacade instance;
    
    private UserFacade(){}
    
    /**
     * 
     * @param _emf
     * @return the instance of this facade.
     */
    public static UserFacade getUserFacade (EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new UserFacade();
        }
        return instance;
    }
    
    public User getVeryfiedUser(String username, String password) throws AuthenticationException {
        EntityManager em = emf.createEntityManager();
        User user;
        try {
            user = em.find(User.class, username);
            if (user == null || !user.verifyPassword(password)) {
                throw new AuthenticationException("Invalid user name or password");
            }
        } finally {
            em.close();
        }
        return user;
    }
    
    public User createNewUser(UserDTO dto) throws ExistingUserException {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User user = new User(dto.getUserName(), dto.getUserPass());
        Role userRole = new Role("user");
        user.addRole(userRole);
        try {
            if (em.find(User.class, dto.getUserName()) != null) {
                throw new ExistingUserException("Username already exists, please choose another username");
            } else {
                em.persist(user);
                em.getTransaction().commit();
            }
        } finally {
            em.close();
        }
        return user;
    }

        public User readUserByUsername(String username) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        try {
            TypedQuery<User> query = em.createQuery("SELECT c FROM User c WHERE c.userName = :user", User.class);
            User user = query.setParameter("user", username).getResultList().get(0);
            return user;
        } finally {
            em.close();
        }
    }
}
