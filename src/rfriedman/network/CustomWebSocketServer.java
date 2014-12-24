package schwimmer.network.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

public class CustomWebSocketServer {

	public static void main( String args[] ) throws Exception {
		Server server = new Server(8080);
		server.setHandler(new WebSocketHandler() {

			@Override
			public void configure(WebSocketServletFactory factory) {
				factory.register(EchoServerWebSocket.class);
			}

		});
		server.start();
		server.join();
	}
	
}
