package friedman.paint;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

import friedman.paint.messages.PaintMessage;
import friedman.paint.messages.PaintMessageFactory;

public class Client extends Thread {

	private Socket socket;
	private OutputStream output;
	private PaintMessageFactory paintFactory;
	private NetworkModule nm;
	private Canvas canvas;


	public Client(String ipAddress, int port, Canvas canvas) throws IOException {
		/*
		 * When the dummyserver is up and running
		 */
		this.canvas = canvas;
		try {
			socket = new Socket(ipAddress, port);
			setNetworkModule(new OnlineNetworkModule(canvas));
			output = socket.getOutputStream();
			canvas.setPrintWriter(new PrintWriter(getOutputStream()));
			start();

		} catch ( IOException e) {
			System.out.println("IO Exception thrown - loopback model");
			setNetworkModule(new LoopbackNetworkModule(canvas));

		} finally {
			
			paintFactory = new PaintMessageFactory(canvas);
		}

	}

	public void run() {
		try {
			InputStream in = socket.getInputStream();

			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			String messageString;
			while ((messageString = reader.readLine()) != null) {
				if (!messageString.equals("\n")) {
					PaintMessage message = paintFactory.getMessage(messageString);
					if (message != null) {
						try {
							message.apply((Graphics2D) canvas.getImage().getGraphics());
							System.out.println(message.toString());
							canvas.repaint();
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
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
