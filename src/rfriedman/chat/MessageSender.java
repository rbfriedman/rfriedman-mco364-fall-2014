package rfriedman.chat;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class MessageSender extends Thread {

	private List<Socket> sockets;
	private BlockingQueue<String> messages;

	public MessageSender(List<Socket> sockets, BlockingQueue<String> messages) {
		super();
		this.sockets = sockets;
		this.messages  =messages;
	}

	public void run() {
		// TODO Auto-generated method stub
		
		while(true){
			
				try {
					String message = messages.take();
					Iterator<Socket> iter = sockets.iterator();
				while(iter.hasNext()){
					Socket socket = iter.next();
					
					try{
						OutputStream out = socket.getOutputStream();
						PrintWriter writer = new PrintWriter(out);
						writer.println(message);
						writer.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}catch(InterruptedException io){
				io.printStackTrace();
			}
	}

}
}
