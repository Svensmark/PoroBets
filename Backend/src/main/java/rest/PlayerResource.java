/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entities.Team;
import entities.dto.PlayerDTO;
import facades.PlayerFacade;
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
@Path("player")
public class PlayerResource {

    private static EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
    private static final PlayerFacade FACADE = PlayerFacade.getPlayerFacade(EMF);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String create(String jsonString) {
        JsonObject json = new JsonParser().parse(jsonString).getAsJsonObject();

        String first_name = json.get("first_name").getAsString();
        String last_name = json.get("last_name").getAsString();
        String ign = json.get("name").getAsString();
        String role = json.get("role").getAsString();
        String image_url = json.get("image_url").getAsString();
        int birthyear = json.get("birth_year").getAsInt();
        String birthday = json.get("birthday").getAsString();
        int api_id = json.get("id").getAsInt();

        PlayerDTO player = new PlayerDTO(first_name, last_name, ign, role, image_url, birthyear, birthday, api_id);
        
        try {
            FACADE.createNewPlayer(player);
            return "{\"response\": \"200 ok\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"response\": \"500 Internal Server Error - Something went wrong\"}";
        }
    }
}
