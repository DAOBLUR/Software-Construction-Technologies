package demoJPA;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Product;

/**
 * Session Bean implementation class DemoService
 */
@Path("DemoService")
@Stateless
@LocalBean
public class DemoService {
	//@PersistenceContext(unitName = "DemoJPA")
	//private EntityManager EM;
	
    public DemoService() {
        // TODO Auto-generated constructor stub
    }
    
    @POST
    @Path("AddProduct")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Product AddProduct(Product newProduct)
    {
    	//EM.persist(newProduct);
    	return newProduct;
    }
}