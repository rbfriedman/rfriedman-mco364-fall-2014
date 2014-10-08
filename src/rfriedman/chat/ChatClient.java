package rfriedman.chat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient extends ChatFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5934716361334721391L;
	private Socket socket;

	public ChatClient() throws UnknownHostException, IOException {
		super("Chat Client");

		socket = new Socket("127.0.0.1",9097);
		setSocket(socket);
		
		new ReadThread(this, socket).start();
	}
	public ChatClient(String title)throws UnknownHostException, IOException {
		super(title);

		socket = new Socket("127.0.0.1",9097);
		setSocket(socket);
		
		new ReadThread(this, socket).start();
	}

	public static void main( String args[] ) throws UnknownHostException, IOException {
		ChatClient clientA = new ChatClient("Rena A");
		clientA.setVisible(true);
		ChatClient clientB = new ChatClient("Rena B");
		clientB.setVisible(true);
		ChatClient clientC = new ChatClient("Rena C" );
		clientC.setVisible(true);
	}

}
