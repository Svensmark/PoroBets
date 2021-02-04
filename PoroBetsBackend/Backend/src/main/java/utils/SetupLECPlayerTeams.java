/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import facades.PlayerFacade;
import facades.TeamFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Emil Svensmark
 */
public class SetupLECPlayerTeams {

    public static void main(String[] args) {

        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
        EntityManager em = emf.createEntityManager();
        TeamFacade tf = TeamFacade.getTeamFacade(emf);
        PlayerFacade pf = PlayerFacade.getPlayerFacade(emf);


        em.getTransaction().begin();
        
        tf.addPlayerToTeam(tf.readTeamByAcronym("AST").getId(), pf.readPlayerByIGN("nukeduck").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("AST").getId(), pf.readPlayerByIGN("Promisq").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("AST").getId(), pf.readPlayerByIGN("Zanzarah").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("AST").getId(), pf.readPlayerByIGN("WhiteKnight").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("AST").getId(), pf.readPlayerByIGN("Jeskla").getId());
        
        tf.addPlayerToTeam(tf.readTeamByAcronym("MAD").getId(), pf.readPlayerByIGN("Armut").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("MAD").getId(), pf.readPlayerByIGN("Carzzy").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("MAD").getId(), pf.readPlayerByIGN("Humanoid").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("MAD").getId(), pf.readPlayerByIGN("Kaiser").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("MAD").getId(), pf.readPlayerByIGN("Elyoya").getId());
        
        tf.addPlayerToTeam(tf.readTeamByAcronym("RGE").getId(), pf.readPlayerByIGN("Hans sama").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("RGE").getId(), pf.readPlayerByIGN("Larssen").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("RGE").getId(), pf.readPlayerByIGN("Odoamne").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("RGE").getId(), pf.readPlayerByIGN("Inspired").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("RGE").getId(), pf.readPlayerByIGN("Trymbi").getId());
        
        tf.addPlayerToTeam(tf.readTeamByAcronym("XL").getId(), pf.readPlayerByIGN("Dan").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("XL").getId(), pf.readPlayerByIGN("Patrik").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("XL").getId(), pf.readPlayerByIGN("Tore").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("XL").getId(), pf.readPlayerByIGN("Kryze").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("XL").getId(), pf.readPlayerByIGN("Czekolad").getId());
        
        tf.addPlayerToTeam(tf.readTeamByAcronym("SK").getId(), pf.readPlayerByIGN("Jenax").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("SK").getId(), pf.readPlayerByIGN("TynX").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("SK").getId(), pf.readPlayerByIGN("Treatz").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("SK").getId(), pf.readPlayerByIGN("Blue").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("SK").getId(), pf.readPlayerByIGN("Jezu").getId());
        
        tf.addPlayerToTeam(tf.readTeamByAcronym("FNC").getId(), pf.readPlayerByIGN("Hylissang").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("FNC").getId(), pf.readPlayerByIGN("Upset").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("FNC").getId(), pf.readPlayerByIGN("Nisqy").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("FNC").getId(), pf.readPlayerByIGN("Bwipo").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("FNC").getId(), pf.readPlayerByIGN("Selfmade").getId());
        
        tf.addPlayerToTeam(tf.readTeamByAcronym("S04").getId(), pf.readPlayerByIGN("Gilius").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("S04").getId(), pf.readPlayerByIGN("Abbedagge").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("S04").getId(), pf.readPlayerByIGN("Broken Blade").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("S04").getId(), pf.readPlayerByIGN("Neon").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("S04").getId(), pf.readPlayerByIGN("LIMIT").getId());
        
        tf.addPlayerToTeam(tf.readTeamByAcronym("VIT").getId(), pf.readPlayerByIGN("Milica").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("VIT").getId(), pf.readPlayerByIGN("Skeanz").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("VIT").getId(), pf.readPlayerByIGN("Labrov").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("VIT").getId(), pf.readPlayerByIGN("Szygenda").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("VIT").getId(), pf.readPlayerByIGN("Comp").getId());
        
        tf.addPlayerToTeam(tf.readTeamByAcronym("G2").getId(), pf.readPlayerByIGN("P1noy").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("G2").getId(), pf.readPlayerByIGN("Mikyx").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("G2").getId(), pf.readPlayerByIGN("Caps").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("G2").getId(), pf.readPlayerByIGN("Wunder").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("G2").getId(), pf.readPlayerByIGN("Rekkles").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("G2").getId(), pf.readPlayerByIGN("Jankos").getId());
        
        tf.addPlayerToTeam(tf.readTeamByAcronym("MSF").getId(), pf.readPlayerByIGN("Kobbe").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("MSF").getId(), pf.readPlayerByIGN("Vander").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("MSF").getId(), pf.readPlayerByIGN("Razork").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("MSF").getId(), pf.readPlayerByIGN("Denyk").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("MSF").getId(), pf.readPlayerByIGN("Agresivoo").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("MSF").getId(), pf.readPlayerByIGN("Hirit").getId());
        tf.addPlayerToTeam(tf.readTeamByAcronym("MSF").getId(), pf.readPlayerByIGN("Vétheo").getId());
        
        em.getTransaction().commit();
    }

}
