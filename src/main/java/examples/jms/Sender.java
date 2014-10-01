package examples.jms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
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

    @Resource(lookup = JMSResources.QUEUE2)
    private Queue queue2;

    /**
     * 
     * @param message
     */
    public void sendMessage(String message) {
        context.createProducer().send(queue, message);
    }

    /**
     * 
     */
    public void sendMessage(int type, int num1, int num2) {
        CalcMessage calcMsg = new CalcMessage();
        calcMsg.setNum1(num1);
        calcMsg.setNum2(num2);

        ObjectMessage msg = context.createObjectMessage(calcMsg);
        try {
            msg.setIntProperty("TYPE", type);
            context.createProducer().send(queue2, msg);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
