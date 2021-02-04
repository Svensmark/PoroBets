/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entities.GameMatch;
import entities.Player;
import entities.Team;
import entities.dto.PlayerDTO;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Emil Svensmark
 */
public class PlayerFacade {

    private static EntityManagerFactory emf;
    private static PlayerFacade instance;

    private PlayerFacade() {
    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static PlayerFacade getPlayerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PlayerFacade();
        }
        return instance;
    }

    public Player createNewPlayer(PlayerDTO dto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Player player = new Player(dto);
        try {
            em.persist(player);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return player;
    }

    public Player readPlayerByIGN(String ign) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        try {
            TypedQuery<Player> query = em.createQuery("SELECT c FROM Player c WHERE c.ign = :ign", Player.class);
            Player player = query.setParameter("ign", ign).getResultList().get(0);
            return player;
        } finally {
            em.close();
        }
    }
}
