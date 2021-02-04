package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.dto.UserDTO;
import facades.UserFacade;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import security.UserPrincipal;
import utils.EMF_Creator;

/**
 * @author lam@cphbusiness.dk
 */
@Path("info")
public class UserInfoResource {

    private static EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final UserFacade FACADE = UserFacade.getUserFacade(EMF);

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String info() {
        return "{\"msg\": \"Hello anonymous\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user")
    @RolesAllowed({"user", "admin"})
    public UserDTO getFromUser() {
        UserPrincipal userPrincipal = (UserPrincipal) securityContext.getUserPrincipal();
        UserDTO user = new UserDTO(userPrincipal.getName(), userPrincipal.getRoles());
        return user;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("admin")
    @RolesAllowed({"admin"})
    public UserDTO getFromAdmin() {
        UserPrincipal userPrincipal = (UserPrincipal) securityContext.getUserPrincipal();
        UserDTO user = new UserDTO(userPrincipal.getName(), userPrincipal.getRoles());
        return user;
    }

}
