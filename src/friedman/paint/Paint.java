package friedman.paint;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;

import javax.swing.JFrame;

import friedman.paint.drawing.PaintLineListener;
import friedman.paint.listeners.BrushStrokeListener;

public class Paint extends JFrame {
	private Canvas canvas;

	public static void main(String[] args) throws IOException {

		Paint paint;
		try {
			paint = new Paint();
			paint.setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Paint() throws UnknownHostException, IOException {

		BorderLayout layout = new BorderLayout();
		Container container = getContentPane();
		container.setLayout(layout);

		canvas = new Canvas(800, 600);
		// My client will switch to loopbacknetworkmodule if an IOException is
		// thrown.
		// I thought that it was a good usage of a try catch loop
		// This can be simulated by
		// a) not running a dummy server
		// b) by changing the port number from 3773 (the Dummy Server's port
		// number)
		Client client = new Client("localhost", 3773, canvas);

		PaintListener paintListener = new PaintLineListener(canvas);
		paintListener.setNetworkModule(client.getNetworkModule());
		PaintBanner paintBanner = new PaintBanner(paintListener);
		canvas.setDrawListener(paintListener);
		canvas.addMouseWheelListener(new BrushStrokeListener(paintBanner));

		add(canvas, BorderLayout.CENTER);
		add(paintBanner, BorderLayout.SOUTH);
		setSize(800, 600);
		setTitle("Paint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		client.start();

	}

}
