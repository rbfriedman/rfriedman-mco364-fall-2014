package friedman.paint;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

import friedman.paint.messages.PaintMessage;
import friedman.paint.messages.PaintMessageFactory;

public class Client extends Thread {

	private Socket socket;
	private OutputStream output;
	private PaintMessageFactory paintFactory;
	private NetworkModule nm;
	private Canvas canvas;
	private String ipAddress;
	private int port;
	private boolean networkConnected;

	public Client(String ipAddress, int port, Canvas canvas) {
		this.canvas = canvas;
		try {
			this.ipAddress = ipAddress;
			this.port = port;
			socket = new Socket(ipAddress, port);
			networkConnected = true;
			output = socket.getOutputStream();
			canvas.setPrintWriter(new PrintWriter(getOutputStream()));
			setNetworkModule(new OnlineNetworkModule(canvas));
			
			start();

		} catch (Exception e) {
			setNetworkModule(new LoopbackNetworkModule(canvas));
			networkConnected = false;

		} finally {
			paintFactory = new PaintMessageFactory(canvas);
		}

	}

	public void run() {
		super.run();
		try {
			InputStream in = socket.getInputStream();

			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));

			String messageString;
			while (networkConnected) {
				try{
				System.out.println("Network Connected? " +  reader.readLine());
				}catch(Exception e){
					e.printStackTrace();
				}
				while ((messageString = reader.readLine()) != null) {
					System.out.println(messageString);
					if (!messageString.equals("\n")) {
						PaintMessage message = paintFactory
								.getMessage(messageString);
						if (message != null) {

							message.apply((Graphics2D) canvas.getImage()
									.getGraphics());
							System.out.println("Message Received");
							canvas.repaint();

						}
					}
				}
			}
			System.out.println("Network Connected? " + networkConnected);
			if(!networkConnected){
				new Client(ipAddress, port, canvas).start();
			}
		} catch (Exception e) {
			new Client(ipAddress, port, canvas).start();
			e.printStackTrace();
		}
	}

	public OutputStream getOutputStream() {
		// TODO Auto-generated method stub
		return output;
	}

	private void setNetworkModule(NetworkModule nm) {
		this.nm = nm;
	}

	public void setCanvas(Canvas canvas) {
		// TODO Auto-generated method stub
		this.canvas = canvas;
	}

	public NetworkModule getNetworkModule() {
		// TODO Auto-generated method stub
		return nm;
	}
}
