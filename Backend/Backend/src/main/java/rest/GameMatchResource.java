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
import entities.GameMatch;
import entities.dto.GameMatchDTO;
import entities.dto.TeamDTO;
import facades.GameMatchFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 *
 * @author Emil Svensmark
 */
@Path("gamematch")
public class GameMatchResource {

    private static EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
    private static final GameMatchFacade FACADE = GameMatchFacade.getGameMatchFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String create(String jsonString) {
        JsonObject json = new JsonParser().parse(jsonString).getAsJsonObject();

        String acronym = json.get("acronym").getAsString();
        String name = json.get("name").getAsString();
        String image_url = json.get("image_url").getAsString();
        int api_id = json.get("id").getAsInt();

        TeamDTO team = new TeamDTO(acronym, name, image_url, api_id);

        try {

            return "{\"response\": \"200 ok\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"response\": \"500 Internal Server Error - Something went wrong\"}";
        }
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String add(String jsonString) {

        try {
            return "{\"response\": \"200 ok\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"response\": \"500 Internal Server Error - Something went wrong\"}";
        }
    }

    @GET
    @Path("/upcoming")
    @Produces(MediaType.APPLICATION_JSON)
    public String upcoming() {
        try {
            String json = "[";
            List<GameMatch> gm = FACADE.readUpcomingMatches();
            for (int i = 0; i < gm.size(); ++i) {
                GameMatchDTO gmdto = new GameMatchDTO(gm.get(i));
                json += gmdto.toJson();
                if (i != gm.size() - 1) {
                    json += ",\n";
                }
            }
            json += "]";
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"response\": \"500 Internal Server Error - Something went wrong\"}";
        }
    }

    @GET
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public String updateDB() {
        try {
            FACADE.saveToDatabaseUpcomingMatches(4710, "past");
            FACADE.saveToDatabaseUpcomingMatches(4710, "upcoming");
            return "{\"response\": \"200 ok\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"response\": \"500 Internal Server Error - Something went wrong\"}";
        }
    }

}
