package friedman.paint;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import com.bric.swing.ColorPalette;
import com.bric.swing.ColorPicker;


public class Paint extends JFrame {

	public static void main(String[] args) {
		Paint paint = new Paint();
		paint.setVisible(true);

	}
	
	public Paint(){
		/*https://javagraphics.java.net/*/
		final ColorPalette picker = new ColorPalette();
		picker.setSize(getWidth(), getHeight()/7);

		BorderLayout layout = new BorderLayout();
		Container container = getContentPane();
		container.setLayout(layout);
		
		Canvas canvas = new Canvas(getWidth(), getHeight());
		canvas.addMouseMotionListener(new PaintListener(canvas));
		canvas.addMouseWheelListener(new BrushStrokeListener(canvas));
		add(picker, BorderLayout.NORTH);
		add(canvas,BorderLayout.CENTER);
		setSize(800,600);
		setTitle("Paint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}

}
