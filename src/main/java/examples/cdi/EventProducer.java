package examples.cdi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 * イベント発生する側
 * 
 * @author t_endo
 */
@SessionScoped
public class EventProducer implements Serializable {

    private static final long serialVersionUID = -577849225517982824L;

    private List<EventItem> items = new ArrayList<>();

    @Inject
    private Event<EventItem> event;

    public void add(String name) {
        EventItem item = new EventItem(name);
        items.add(item);
        event.fire(item);
    }
}
