package examples.jms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 * 
 * @author t_endo
 */
@Stateless
public class Receiver {

    @Inject
    private JMSContext context;

    @Resource(lookup = JMSResources.QUEUE)
    private Queue queue;

    public String startReceiver() {
        String message = context.createConsumer(queue)
                .receiveBody(String.class);
        return message;
    }
}
