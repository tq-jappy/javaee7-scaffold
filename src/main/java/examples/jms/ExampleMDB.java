package examples.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import examples.ejb.CalcEjb;

/**
 * メッセージの TYPE プロパティが 1 の時用のMDB
 * 
 * @author t_endo
 */
@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup",
                propertyValue = JMSResources.QUEUE2),
        @ActivationConfigProperty(propertyName = "destinationType",
                propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "messageSelector",
                propertyValue = "TYPE = 1") })
public class ExampleMDB implements MessageListener {

    @EJB
    private CalcEjb calc;

    @Override
    public void onMessage(Message message) {
        try {
            CalcMessage msg = message.getBody(CalcMessage.class);

            int result = calc.add(msg.getNum1(), msg.getNum2());
            System.out.println("received message from MDB1");
            System.out.println("calc(" + msg.getNum1() + ", " + msg.getNum2()
                    + ") = " + result);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
