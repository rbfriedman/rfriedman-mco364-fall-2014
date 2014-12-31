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

public class Client extends Thread {

	private Socket socket;
	private OutputStream output;
	private PaintMessageFactory paintFactory;
	private NetworkModule nm;
	private Canvas canvas;

	public Client() {
		try {
			socket = new Socket("192.168.117.107", 3773);
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

	public Client(String ipAddress, int port, Canvas canvas) throws IOException {
		this.canvas = canvas;
		try {
			socket = new Socket(ipAddress, port);
			setNetworkModule(new OnlineNetworkModule(canvas));
			start();

		} catch (UnknownHostException e) {
			socket = new Socket(ipAddress, port);
			setNetworkModule(new LoopbackNetworkModule(canvas));

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			output = socket.getOutputStream();
			paintFactory = new PaintMessageFactory();
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
