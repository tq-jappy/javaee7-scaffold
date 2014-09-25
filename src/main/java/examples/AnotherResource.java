package examples;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import examples.jms.Sender;

/**
 * 
 * @author t_endo
 */
@Path("/misc")
@Consumes(MediaType.APPLICATION_JSON)
public class AnotherResource {

    @EJB
    private Sender sender;

    @GET
    @Path("{name}")
    public String sendMessage(@PathParam("name") String name) {
        sender.sendMessage(name);
        return "OK";
    }
}
