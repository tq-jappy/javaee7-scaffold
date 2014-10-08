package examples.websocket;

import java.io.IOException;

import javax.inject.Inject;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;

/**
 * echo用のWebSocketエンドポイント。
 *
 * @author t_endo
 */
@ServerEndpoint("/echo")
public class EchoEndpoint {

    @Inject
    private Logger logger;

    @OnOpen
    public void onMessage(Session session) throws IOException {
        logger.debug("onMessage.");

        session.getBasicRemote().sendText("onOpen");
    }

    /**
     * 接続中の全クライアントに対して受け取ったメッセージを送信する。
     * 
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        logger.debug("get message: {}", message);

        session.getOpenSessions().forEach((peer) -> {
            try {
                peer.getBasicRemote().sendText(message);
            } catch (IOException e) {
            }
        });
    }
}
