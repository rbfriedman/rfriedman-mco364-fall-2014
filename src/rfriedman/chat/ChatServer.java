package rfriedman.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;



public class ChatServer extends ChatFrame{
	private ServerSocket server;

	public ChatServer() throws UnknownHostException, IOException {
		super("Chat Server");
		
		server = new ServerSocket(9097);
		
		new Thread() {
			public void run() {
				try {
					Socket socket = server.accept();
					setSocket(socket);
					new ReadThread(ChatServer.this, socket).start();
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
	
	public ChatServer(String title) throws UnknownHostException, IOException {
		
		super(title);
		
		//thread functionality decided by subclass
	}
	
	public static void main( String args[] ) throws UnknownHostException, IOException {
		ChatServer server = new ChatServer();
		server.setVisible(true);
	}

}