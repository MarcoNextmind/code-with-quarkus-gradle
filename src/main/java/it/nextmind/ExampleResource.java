package it.nextmind;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {
	@Inject
	EntityManager em; 
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
    	System.out.println(em);
        return "hello";
    }
}