package friedman.paint;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DummyServer {
	private ServerSocket server;
	public DummyServer() throws IOException{
	server = new ServerSocket(7337);

	new Thread() {
		public void run() {
			try {
				Socket socket = server.accept();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	}.start();
	}
	
	public static void main(String[] args) throws IOException{
		DummyServer f = new DummyServer();
		
	}
}
