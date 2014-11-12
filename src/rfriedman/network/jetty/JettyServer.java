package rfriedman.network.jetty;

import org.eclipse.jetty.server.Server;

public class JettyServer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Server server = new Server(1891);
		server.start();
		//http://www.eclipse.org/jetty/documentation/current/jndi-embedded.html
	}

}
