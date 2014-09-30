package rfriedman.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class ChatServer implements Runnable{
	private ChatFrame frame;

	//public static void main(String[] args) {
	//	new ChatServer();
	//}

	public ChatServer(ChatFrame frame) {
		this.frame = frame;

	}

	public void run() {
		try {
			ServerSocket serverSocket = new ServerSocket(8080);
			while (true) {
				Socket socket = serverSocket.accept();

				ServerThreads task = new ServerThreads(socket, frame);

				new Thread(task).start();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}