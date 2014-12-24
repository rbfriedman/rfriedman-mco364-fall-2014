package schwimmer.network.jetty;

import java.io.IOException;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@WebSocket(maxTextMessageSize = 64 * 1024)
public class EchoClientWebSocket {
    private Session session;
 
    public EchoClientWebSocket() {
    }
 
 
    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        this.session = null;
    }
 
    @OnWebSocketConnect
    public void onConnect(Session session) {
        System.out.printf("Got connect: %s%n", session);
        this.session = session;
        try {
			session.getRemote().sendString("Hello");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
 
    @OnWebSocketMessage
    public void onMessage(String msg) {
        System.out.printf("Got msg: %s%n", msg);
        session.close();
    }
}
