package schwimmer.network.jetty;

import org.eclipse.jetty.server.Server;

public class HttpServer {

	public static void main(String args[]) throws Exception {
		Server server = new Server(8080);
		server.setHandler(new HttpHandler());
		server.start();
		server.join();
	}
	
}
