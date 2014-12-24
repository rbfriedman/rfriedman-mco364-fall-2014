package friedman.paint;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JFrame;

import friedman.paint.drawing.PaintLineListener;
import friedman.paint.listeners.BrushStrokeListener;

public class Paint extends JFrame {
	private Canvas canvas;

	public static void main(String[] args) throws UnknownHostException, IOException {

Client client = new Client();
		Paint paint = new Paint(client);
		paint.setVisible(true);

	}

	public Paint(Client client) throws UnknownHostException, IOException {

		BorderLayout layout = new BorderLayout();
		Container container = getContentPane();
		container.setLayout(layout);
		canvas = new Canvas(800, 600,client);

		PaintListener paintListener = new PaintLineListener(canvas);
		PaintBanner paintBanner = new PaintBanner(paintListener);
		canvas.setDrawListener(paintListener);
		canvas.addMouseWheelListener(new BrushStrokeListener(paintBanner));

		add(canvas, BorderLayout.CENTER);
		add(paintBanner, BorderLayout.SOUTH);
		setSize(800, 600);
		setTitle("Paint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	
		
	}

}
