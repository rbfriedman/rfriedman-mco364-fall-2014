package friedman.paint;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

import com.bric.swing.ColorPalette;
import com.bric.swing.ColorPicker;

public class Paint extends JFrame{
	private Canvas canvas;

	public static void main(String[] args) {
		Paint paint = new Paint();
		paint.setVisible(true);

	}

	public Paint() {
		/* https://javagraphics.java.net/ */
		// final ColorPalette picker = new ColorPalette();
		// picker.setSize(getWidth(), getHeight()/7);

		BorderLayout layout = new BorderLayout();
		Container container = getContentPane();
		container.setLayout(layout);
		canvas = new Canvas(800, 600);
		
		PaintListener paintListener = new PaintListener(canvas);
		PaintBanner paintBanner = new PaintBanner(paintListener);
		canvas.addMouseMotionListener(paintListener);
		canvas.addMouseWheelListener(new BrushStrokeListener(paintBanner));

		// add(picker, BorderLayout.NORTH);
		add(canvas, BorderLayout.CENTER);
		add(paintBanner, BorderLayout.SOUTH);
		setSize(800, 600);
		setTitle("Paint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}




}
