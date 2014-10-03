package examples.websocket;

import java.io.IOException;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * echo用のWebSocketエンドポイント。
 *
 * @author t_endo
 */
@ServerEndpoint("/echo")
public class EchoEndpoint {

    @OnOpen
    public void onMessage(Session session) throws IOException {
        System.out.println("onMessage.");

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
        System.out.println("get message: " + message);

        session.getOpenSessions().forEach((peer) -> {
            try {
                peer.getBasicRemote().sendText(message);
            } catch (IOException e) {
            }
        });
    }
}
