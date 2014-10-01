package examples.jms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 * {@link JMSConsumer} を使ったメッセージ受信クラス
 * 
 * @author t_endo
 */
@Stateless
public class Receiver {

    @Inject
    private JMSContext context;

    @Resource(lookup = JMSResources.QUEUE1)
    private Queue queue;

    public String receiveMessageSync() {
        String message = context.createConsumer(queue)
                .receiveBody(String.class);
        return message;
    }
}
