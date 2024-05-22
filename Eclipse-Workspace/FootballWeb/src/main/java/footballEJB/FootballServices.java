package footballEJB;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import FootballModels.*;

@Path("FootballEJB")
@Stateless
@LocalBean
public class FootballServices {
	@PersistenceContext(unitName = "FootballJPA")
	private EntityManager entityManager;
		
    public FootballServices() {
    	
    }

    @Path("GetPlayerName")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String GetPlayerName (@QueryParam("id") int id) {
    	//System.out.println("Response from: " + this);
    	Player player = entityManager.find(Player.class, id);
    	
    	if(player == null) return "Not found";
    	
    	return player.getFirstname();
    }
    
    @Path("AddPlayer")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String AddPlayer(Player newPlayer) {
    	try {
    		Player player = entityManager.find(Player.class, newPlayer.getId());
    		
    		if(player != null) {
    			return "Already exist";
    		}
    		
			Stadium stadium = entityManager.find(Stadium.class, newPlayer.getClubid());
    		
    		if(stadium == null) {
    			return "Failed";
    		}
    		
			entityManager.persist(newPlayer);
			return "Success";
		} 
    	catch (Exception e) {
			return "Failed";
		}
    }
}