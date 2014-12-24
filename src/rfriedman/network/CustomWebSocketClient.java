package schwimmer.network.jetty;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

public class CustomWebSocketClient {

	public static void main( String args[] ) {
		
        WebSocketClient client = new WebSocketClient();
        EchoClientWebSocket socket = new EchoClientWebSocket();
        try {
            client.start();
            URI echoUri = new URI("ws://localhost:8080");
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            client.connect(socket, echoUri, request);
        } catch (Throwable t) {
            t.printStackTrace();
        }
		
	}
	
}
