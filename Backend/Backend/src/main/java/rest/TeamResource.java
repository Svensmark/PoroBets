/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entities.dto.TeamDTO;
import facades.TeamFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 *
 * @author Emil Svensmark
 */
@Path("team")
public class TeamResource {

    private static EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
    private static final TeamFacade FACADE = TeamFacade.getTeamFacade(EMF);

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
            FACADE.createNewTeam(team);
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
        JsonObject json = new JsonParser().parse(jsonString).getAsJsonObject();

        Long teamID = json.get("teamID").getAsLong();
        Long playerID = json.get("playerID").getAsLong();

        try {
            FACADE.addPlayerToTeam(teamID, playerID);
            return "{\"response\": \"200 ok\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"response\": \"500 Internal Server Error - Something went wrong\"}";
        }
    }

    @GET
    @Path("/acronym/{acronym}")
    @Produces(MediaType.APPLICATION_JSON)
    public String upcoming(@PathParam("acronym")String acronym) {
        return new TeamDTO(FACADE.readTeamByAcronym(acronym)).toJson();
    }
}
