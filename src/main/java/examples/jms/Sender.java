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

    @Resource(lookup = JMSResources.QUEUE1)
    private Queue queueForConsumer;

    @Resource(lookup = JMSResources.QUEUE2)
    private Queue queueForMDB;

    /**
     * Consumer 宛にメッセージを送信する。
     * 
     * @param message
     *            送信メッセージ
     */
    public void sendMessage(String message) {
        context.createProducer().send(queueForConsumer, message);
    }

    /**
     * MDB 宛にメッセージを送信する。
     * 
     * @param type
     *            送信タイプ。
     * @param num
     *            メッセージに含める数値
     * @param str
     *            メッセージに含める文字列
     */
    public void sendMessageToMDB(String type, int num, String str) {
        SimpleMessage message = new SimpleMessage();
        message.setANumber(num);
        message.setAString(str);

        ObjectMessage msg = context.createObjectMessage(message);
        try {
            msg.setStringProperty("TYPE", type);
            context.createProducer().send(queueForMDB, msg);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
