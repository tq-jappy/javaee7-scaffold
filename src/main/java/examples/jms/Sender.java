package examples.jms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.DeliveryMode;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 * 
 * @author t_endo
 */
@Stateless
public class Sender {

    @Resource(mappedName = JMSService.QUEUE)
    private Queue queue;

    @Inject
    private JMSContext context;

    public void sendMessage(String message) {
        context.createProducer().setPriority(2).setTimeToLive(1000)
                .setDeliveryMode(DeliveryMode.NON_PERSISTENT)
                .send(queue, message);
    }
}
