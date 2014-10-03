package examples.jaxrs;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * JAX-RSでのRESTを有効にする。
 * 
 * @author t_endo
 */
@ApplicationPath("/api")
public class JaxrsActivator extends Application {
}
