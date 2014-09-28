package examples.jaxrs;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import examples.ejb.HelloEjb;
import examples.jms.Sender;

/**
 * 
 * @author t_endo
 */
@Path("/examples")
@Consumes(MediaType.APPLICATION_JSON)
public class ExampleResource {

    @EJB
    private HelloEjb hello;

    @EJB
    private Sender sender;

    @GET
    @Path("/hello/{name}")
    public String greet(@PathParam("name") String name) {
        return hello.greet(name);
    }
}
