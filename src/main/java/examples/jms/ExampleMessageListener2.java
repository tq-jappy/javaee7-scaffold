package examples.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;

/**
 * メッセージの TYPE プロパティが 'B' の時のメッセージを処理するMDB
 * 
 * @author t_endo
 */
@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup",
                propertyValue = JMSResources.QUEUE2),
        @ActivationConfigProperty(propertyName = "destinationType",
                propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "messageSelector",
                propertyValue = "TYPE <> 'A'") })
public class ExampleMessageListener2 implements MessageListener {

    @Inject
    private Logger logger;

    @Override
    public void onMessage(Message message) {
        try {
            SimpleMessage body = message.getBody(SimpleMessage.class);

            logger.info("received message from MDB2: {}", body);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
