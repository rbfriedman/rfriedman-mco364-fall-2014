package rfriedman.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MultiChatServer extends ChatServer{

	public MultiChatServer() throws UnknownHostException, IOException {
		super("Multi Chat Server");
		// TODO Auto-generated constructor stub

		ServerSocket serverSocket = new ServerSocket(9097);
		List<Socket> sockets = new ArrayList<Socket>();
		Queue<String> messages = new LinkedBlockingQueue<String>();
		MessageSender sender = new MessageSender(sockets, (LinkedBlockingQueue <String>)messages);
		sender.start();
		while (true) {

			Socket socket = serverSocket.accept();
			sockets.add(socket);
			SocketHandler handler = new SocketHandler(socket, messages, MultiChatServer.this);
			handler.start();
			setSocket(socket);
			new ReadThread(MultiChatServer.this, socket).start();
		}
	
	}

	public static void main(String[] args) throws IOException {
		MultiChatServer multi = new MultiChatServer();
	}
}
