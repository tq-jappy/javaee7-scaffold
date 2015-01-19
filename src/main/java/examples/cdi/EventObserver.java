package examples.cdi;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;

/**
 * 
 * @author t_endo
 */
@RequestScoped
public class EventObserver {

    public void receive(@Observes EventItem item) {
        System.out.println("event received: " + item);
    }
}
