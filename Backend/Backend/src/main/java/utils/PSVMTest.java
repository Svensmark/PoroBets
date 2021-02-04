/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entities.GameMatch;
import entities.dto.GameMatchDTO;
import facades.GameMatchFacade;
import facades.TeamFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Emil Svensmark
 */
public class PSVMTest {

    public static void main(String[] args) {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3306/cvwebsite",
                "root",
                EMF_Creator.Strategy.CREATE);
        EntityManager em = emf.createEntityManager();

        GameMatchFacade gmf = GameMatchFacade.getGameMatchFacade(emf);
        TeamFacade tf = TeamFacade.getTeamFacade(emf);

        List<GameMatch> matches = gmf.readUpcomingMatches();
        for (GameMatch gm : matches) {
            System.out.println(new GameMatchDTO(gmf.readUpcomingMatches().get(0)).toJson());
        }

        
        System.out.println(gmf.readUpcomingMatches());
    }

}
