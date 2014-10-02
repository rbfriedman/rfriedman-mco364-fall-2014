package rfriedman.chat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient extends ChatFrame{
	private Socket socket;

	public ChatClient() throws UnknownHostException, IOException {
		super("Chat Client");

		socket = new Socket("127.0.0.1",9097);
		setSocket(socket);
		
		new ReadThread(this, socket).start();
	}

	public static void main( String args[] ) throws UnknownHostException, IOException {
		ChatClient client = new ChatClient();
		client.setVisible(true);
	}

}
