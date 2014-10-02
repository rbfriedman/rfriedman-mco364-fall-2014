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

	public SocketHandler(Socket s,Queue messages) {
		super();
		this.s = s;
		this.messages = messages;
	}
	
	public void run(){
		try{
			InputStream in = s.getInputStream();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			String line;
			while((line = reader.readLine())!=null){
				messages.add(line);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
