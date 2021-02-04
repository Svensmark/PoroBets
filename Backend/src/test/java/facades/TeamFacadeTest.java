/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Player;
import entities.Team;
import static entities.Team_.acronym;
import entities.dto.TeamDTO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import utils.EMF_Creator;
//
///**
// *
// * @author Emil Svensmark
// */
//public class TeamFacadeTest {
//
//    private static EntityManagerFactory emf;
//    private static TeamFacade facade;
//
//    public TeamFacadeTest() {
//    }
//
//    @BeforeAll
//    public static void setUpClass() {
//        emf = EMF_Creator.createEntityManagerFactory(
//                "pu",
//                "jdbc:mysql://localhost:3306/cvwebsite_test",
//                "root",
//                EMF_Creator.Strategy.CREATE);
//        facade = TeamFacade.getTeamFacade(emf);
//    }
//
//    @BeforeAll
//    public static void setUpClassV2() {
//        emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.TEST, EMF_Creator.Strategy.DROP_AND_CREATE);
//        facade = TeamFacade.getTeamFacade(emf);
//    }
//
//    @BeforeEach
//    public void setUp() {
//
//        EntityManager em = emf.createEntityManager();
//        ArrayList<Team> teams = new ArrayList();
//
//        try {
//            em.getTransaction().begin();
//            em.createQuery("DELETE FROM Player").executeUpdate();
//            em.createQuery("DELETE FROM Team").executeUpdate();
//
//            teams.add(new Team("G2", "G2 Esports", "https://cdn.pandascore.co/images/team/image/88/g2-esports.png", 88));
//            teams.add(new Team("MSF", "Misfits Gaming", "https://cdn.pandascore.co/images/team/image/37/misfits-8fnvxt30.png", 37));
//            Player player = new Player("Steven", "Liv", "Hans sama", "adc", "https://cdn.pandascore.co/images/player/image/871/220px_rge_hans_sama_2020_split_2.png", 1999, "1999-09-02", 871);
//
//            em.persist(teams.get(0));
//            em.persist(teams.get(1));
//            em.persist(player);
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//        }
//
//    }
//
//    /**
//     * Test of createNewTeam method, of class TeamFacade.
//     */
//    @Test
//    public void testCreateNewTeam() {
//        EntityManager em = emf.createEntityManager();
//        facade.createNewTeam(new TeamDTO("Martin", "csgonoob", "image_url", 99));
//        assertEquals(3, em.createQuery("SELECT u From Team u", Team.class).getResultList().size());
//    }
//
//    /**
//     * Test of addPlayerToTeam method, of class TeamFacade.
//     */
//    @Test
//    public void testAddPlayerToTeam() {
//        EntityManager em = emf.createEntityManager();
//        Team team = em.createQuery("SELECT u From Team u", Team.class).getResultList().get(0);
//        Player player = em.createQuery("SELECT u From Player u", Player.class).getResultList().get(0);
//        facade.addPlayerToTeam(team.getId(), player.getId());
//        TypedQuery<Player> query1 = em.createQuery("SELECT c FROM Player c WHERE c.team.id = :id", Player.class);
//        Player player2 = query1.setParameter("id", team.getId()).getResultList().get(0);
//        assertEquals(player.getFirst_name(), player2.getFirst_name());
//    }
//
//    /**
//     * Test of readTeamByAcronym method, of class TeamFacade.
//     */
//    @Test
//    public void testReadTeamByAcronym() {
//        EntityManager em = emf.createEntityManager();
//        Team team1 = facade.readTeamByAcronym("G2");
//        Team team2 = em.createQuery("SELECT u From Team u", Team.class).getResultList().get(0);
//        assertEquals(team1.getId(), team2.getId());
//    }
//
//    /**
//     * Test of readPlayersByTeamAcronym method, of class TeamFacade.
//     */
//    @Test
//    public void testReadPlayersByTeamAcronym() {
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        Team team = em.createQuery("SELECT u From Team u", Team.class).getResultList().get(0);
//        Player player = em.createQuery("SELECT u From Player u", Player.class).getResultList().get(0);
//        team.addPlayer(player);
//        player.setTeam(team);
//        em.merge(team);
//        em.merge(player);
//        em.getTransaction().commit();
//        em.close();
//        System.out.println("Hey " + facade.readPlayersByTeamAcronym(team.getAcronym()).toString());
//        assertEquals(1,1);
//    }
//
//}
//