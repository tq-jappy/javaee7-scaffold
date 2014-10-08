package examples.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;

/**
 * メッセージの TYPE プロパティが 'A' の時のメッセージを処理するMDB
 * 
 * @author t_endo
 */
@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup",
                propertyValue = JMSResources.QUEUE2),
        @ActivationConfigProperty(propertyName = "destinationType",
                propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "messageSelector",
                propertyValue = "TYPE = 'A'") })
public class ExampleMessageListener1 implements MessageListener {

    @Inject
    private Logger logger;

    @Override
    public void onMessage(Message message) {
        try {
            SimpleMessage body = message.getBody(SimpleMessage.class);

            logger.debug("received message from MDB1: {}", body);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
