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
public class Sender {

    @Inject
    private JMSContext context;

    @Resource(lookup = JMSResources.QUEUE)
    private Queue queue;

    public void sendMessage(String message) {
        context.createProducer().send(queue, message);
    }
}
