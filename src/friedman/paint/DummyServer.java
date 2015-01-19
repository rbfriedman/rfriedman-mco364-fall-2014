package friedman.paint;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DummyServer {
	private ServerSocket server;
	private int portNumber;

	public DummyServer() throws IOException {
		this.portNumber = 7237;
		server = new ServerSocket(this.portNumber);

		new Thread() {
			public void run() {
				while (true) {
					try {
						Socket socket = server.accept();
						System.out.println("Server running");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		}.start();
	}

	public static void main(String[] args) throws IOException {
		DummyServer f = new DummyServer();

	}

	public int getPortNumber() {
		// TODO Auto-generated method stub
		return this.portNumber;
	}
}
