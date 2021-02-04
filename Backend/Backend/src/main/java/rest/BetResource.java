/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entities.dto.BetDTO;
import facades.BetFacade;
import facades.GameMatchFacade;
import facades.UserFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 *
 * @author Emil Svensmark
 */
@Path("bet")
public class BetResource {

    private static EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
    private static final BetFacade FACADE = BetFacade.getBetFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String create(String jsonString) {
        JsonObject json = new JsonParser().parse(jsonString).getAsJsonObject();
        try {
            Long gamematch_id = json.get("gamematch_id").getAsLong();
            String username = json.get("username").getAsString();
            int amount = json.get("amount").getAsInt();
            int winner_api_id = json.get("winner_api_id").getAsInt();
            boolean active = true;

            BetDTO bet = new BetDTO(gamematch_id, username, amount, winner_api_id, active);

            FACADE.createBet(bet);
            
            return "{\"response\": \"200 ok\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"response\": \"500 Internal Server Error - Something went wrong\"}";
        }
    }

}
