/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Bet;
import entities.GameMatch;
import entities.dto.BetDTO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Emil Svensmark
 */
public class BetFacade {

    private static EntityManagerFactory emf;
    private static BetFacade instance;

    private BetFacade() {
    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static BetFacade getBetFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BetFacade();
        }
        return instance;
    }

    public Bet createBet(BetDTO dto) {
        EntityManager em = emf.createEntityManager();
        Bet bet = new Bet(dto);
        try {
            em.getTransaction().begin();
            em.persist(bet);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return bet;
    }

    public List<GameMatch> readUpcomingMatches() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            TypedQuery<GameMatch> query = em.createQuery("SELECT c FROM GameMatch c WHERE c.winner_api_id = :value", GameMatch.class);
            return query.setParameter("value", 0).getResultList();
        } finally {
            em.close();
        }
    }
}
