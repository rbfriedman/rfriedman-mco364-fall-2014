package friedman.paint;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

import friedman.paint.messages.PaintMessage;
import friedman.paint.messages.PaintMessageFactory;

public class Client extends Thread{

	private Socket socket;
	private OutputStream output;
	private PaintMessageFactory paintFactory;
	private NetworkModule nm;
	private Canvas canvas;
	

	public Client()  {
		try {
			socket = new Socket("localhost", 7337);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			output = socket.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Client(String ipAddress, int port){
		
			try {
				socket = new Socket(ipAddress, port);
				output = socket.getOutputStream();
				nm = new OnlineNetworkModule(canvas);
				start();

			} catch (UnknownHostException e) {
				nm = new LoopbackNetworkModule(canvas);
				e.printStackTrace();
			}catch( IOException e){
				e.printStackTrace();
			}finally{
				paintFactory = new PaintMessageFactory();
			}
			
		
	}
	
	public void run(){
		try {
		InputStream in = socket.getInputStream();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		String messageString;
		while ((messageString = reader.readLine()) != null)
		{
			if (!messageString.equals("\n")) 
			{
				PaintMessage message = paintFactory.receiveMessage(messageString);
				if (message != null)
				{
					message.apply((Graphics2D) canvas.getImage().getGraphics());
					canvas.repaint();
				}
			}
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	

	public OutputStream getOutputStream() {
		// TODO Auto-generated method stub
		return output;
	}
	
	private void setNetworkModule(NetworkModule nm){
		this.nm = nm;
	}

	public void setCanvas(Canvas canvas) {
		// TODO Auto-generated method stub
		this.canvas= canvas;
	}
}
