package examples.jsf;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import examples.jms.Receiver;
import examples.jms.Sender;

/**
 * JMSのサンプル用のView
 * 
 * @author t_endo
 */
@Named("messagingBean")
@ViewScoped
public class MessagingBean implements Serializable {

    private static final long serialVersionUID = 1001540175242502993L;

    @Inject
    private Sender sender;

    @Inject
    private Receiver receiver;

    @Setter
    @Getter
    private String message;

    @Getter
    private List<String> receivedMessages = new ArrayList<>();

    public void send() throws IOException {
        sender.sendMessage(message);
        this.message = "";
    }

    public void receive() {
        String receivedMessage = receiver.startReceiver();
        receivedMessages.add(receivedMessage);
    }
}
