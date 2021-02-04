/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Player;
import entities.Team;
import entities.dto.TeamDTO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Emil Svensmark
 */
public class TeamFacade {

    private static EntityManagerFactory emf;
    private static TeamFacade instance;

    private TeamFacade() {
    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static TeamFacade getTeamFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new TeamFacade();
        }
        return instance;
    }

    public Team createNewTeam(TeamDTO dto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Team team = new Team(dto);
        try {
            em.persist(team);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return team;
    }

    public Team addPlayerToTeam(Long teamID, Long playerID) {
        EntityManager em = emf.createEntityManager();
        Team team = null;
        try {
            em.getTransaction().begin();
            team = em.find(Team.class, teamID);
            Player player = em.find(Player.class, playerID);

            team.addPlayer(player);
            player.setTeam(team);

            em.merge(team);
            em.merge(player);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return team;
    }

    public Team readTeamByAcronym(String acronym) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        try {
            TypedQuery<Team> query = em.createQuery("SELECT c FROM Team c WHERE c.acronym = :acronym", Team.class);
            Team team = query.setParameter("acronym", acronym).getResultList().get(0);
            ArrayList<Player> players =  new ArrayList(team.getPlayers());
            team.setPlayers(players);
            return team;
        } finally {
            em.close();
        }
    }

    public List<Player> readPlayersByTeamAcronym(String acronym) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        try {
            TypedQuery<Team> query1 = em.createQuery("SELECT c FROM Team c WHERE c.acronym = :acronym", Team.class);
            Team team = query1.setParameter("acronym", acronym).getResultList().get(0);
            TypedQuery<Player> query2 = em.createQuery("SELECT c FROM Player c WHERE c.team.id = :teamid", Player.class);
            return query2.setParameter("teamid", team.getId()).getResultList();
        } finally {
            em.close();
        }
    }

}
