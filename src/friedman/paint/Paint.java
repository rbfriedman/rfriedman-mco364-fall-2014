package friedman.paint;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

import friedman.paint.drawing.PaintLineListener;
import friedman.paint.listeners.BrushStrokeListener;
import friedman.paint.listeners.PaintListener;

public class Paint extends JFrame {
	private Canvas canvas;

	public static void main(String[] args) {
		Paint paint = new Paint();
		paint.setVisible(true);

	}

	public Paint() {

		BorderLayout layout = new BorderLayout();
		Container container = getContentPane();
		container.setLayout(layout);
		canvas = new Canvas(1100, 800);

		PaintListener paintListener = new PaintLineListener(canvas);
		PaintBanner paintBanner = new PaintBanner(paintListener);
		canvas.setDrawListener(paintListener);
		canvas.addMouseWheelListener(new BrushStrokeListener(paintBanner));

		add(canvas, BorderLayout.CENTER);
		add(paintBanner, BorderLayout.SOUTH);
		
		setSize(1100, 900);
		setTitle("Paint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}

}
