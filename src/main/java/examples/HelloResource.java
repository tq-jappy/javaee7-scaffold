package examples;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * 
 * @author t_endo
 */
@Path("/hello")
@Consumes(MediaType.APPLICATION_JSON)
public class HelloResource {

    @EJB
    private HelloEjb hello;

    @GET
    @Path("/{name}")
    public String get(@PathParam("name") String name) {
        return hello.greet(name);
    }
}
