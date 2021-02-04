package utils;


import facades.GameMatchFacade;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Emil Svensmark
 */
public class SetupLECMatches {
    
    private static EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
    private static final GameMatchFacade FACADE = GameMatchFacade.getGameMatchFacade(EMF);
    
    public static void main(String[] args) throws Exception {
        FACADE.saveToDatabaseUpcomingMatches(4710, "past");
    }
    
}
