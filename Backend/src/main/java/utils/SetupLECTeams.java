/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entities.Player;
import entities.Team;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Emil Svensmark
 */
public class SetupLECTeams {

    public static void main(String[] args) {

        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
        EntityManager em = emf.createEntityManager();
        
        ArrayList<Team> teams = new ArrayList();
        teams.add(new Team("AST", "Astralis", "https://cdn.pandascore.co/images/team/image/128044/astralislogo_square.png",128044));
        teams.add(new Team("MAD", "MAD Lions", "https://cdn.pandascore.co/images/team/image/126536/220px_mad_lions_e.c.__lec_team_logo_profile.png",126536));
        teams.add(new Team("RGE", "Rogue", "https://cdn.pandascore.co/images/team/image/3983/rogue__28_european_team_29logo_square.png",3983));
        teams.add(new Team("XL", "Excel Esports", "https://cdn.pandascore.co/images/team/image/2721/05p9d7k_s_400x400.png",2721));
        teams.add(new Team("SK", "SK Gaming", "https://cdn.pandascore.co/images/team/image/395/600px-SK_Gaminglogo_square.png",395));
        teams.add(new Team("FNC", "Fnatic", "https://cdn.pandascore.co/images/team/image/394/220px_fnaticlogo_square.png",394));
        teams.add(new Team("S04", "FC Schalke 04 Esports", "https://cdn.pandascore.co/images/team/image/204/fc-schalke-04-h992ofkj.png",204));
        teams.add(new Team("VIT", "Team Vitality", "https://cdn.pandascore.co/images/team/image/115/Team_Vitalitylogo_square.png",115));
        teams.add(new Team("G2", "G2 Esports", "https://cdn.pandascore.co/images/team/image/88/g2-esports.png",88));
        teams.add(new Team("MSF", "Misfits Gaming", "https://cdn.pandascore.co/images/team/image/37/misfits-8fnvxt30.png",37));

        em.getTransaction().begin();        
        for (int i = 0; i < teams.size(); ++i) {
            em.persist(teams.get(i));
        }
        em.getTransaction().commit();

    }

}
