package rfriedman.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Queue;

public class SocketHandler extends Thread{

	
	private Socket s;
	private Queue<String> messages;
	private ChatServer chatServer;

	public SocketHandler(Socket s,Queue messages, ChatServer chatServer) {
		super();
		this.s = s;
		this.messages = messages;
		this.chatServer = chatServer;
	}
	
	public void run(){
		try{
			InputStream in = s.getInputStream();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			String line;
			while((line = reader.readLine())!=null){
				messages.add(line);
				chatServer.appendMessage(line);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
