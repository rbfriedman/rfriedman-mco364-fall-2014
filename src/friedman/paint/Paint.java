package friedman.paint;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

import com.bric.swing.ColorPalette;
import com.bric.swing.ColorPicker;


public class Paint extends JFrame implements MouseMotionListener {
	private Canvas canvas;

	public static void main(String[] args) {
		Paint paint = new Paint();
		paint.setVisible(true);

	}
	
	public Paint(){
		/*https://javagraphics.java.net/*/
		//final ColorPalette picker = new ColorPalette();
		//picker.setSize(getWidth(), getHeight()/7);

		BorderLayout layout = new BorderLayout();
		Container container = getContentPane();
		container.setLayout(layout);
		
		
		
		canvas = new Canvas(700, 500);
		PaintBanner paintBanner = new PaintBanner(canvas);
		canvas.addMouseMotionListener(this);
		canvas.addMouseWheelListener(new BrushStrokeListener(canvas,paintBanner));
		
		
		//add(picker, BorderLayout.NORTH);
		add(canvas,BorderLayout.CENTER);
		add(paintBanner, BorderLayout.SOUTH);
		setSize(800,600);
		setTitle("Paint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	public void mouseDragged(MouseEvent e) {
		System.out.println("Dragged");
		if (!canvas.isClicked()) {
			canvas.setPointOrigin(e.getX(), e.getY());
			canvas.setPointNext(e.getX(), e.getY());
			canvas.setClicked(true);
		} else {
			canvas.setPointOrigin(canvas.getNextPoint()[0],
					canvas.getNextPoint()[1]);
			canvas.setPointNext(e.getX(), e.getY());
		}
		canvas.drawLine();
		canvas.repaint();

	}

	public void mouseMoved(MouseEvent e) {
		canvas.setClicked(false);

	}

	private void saySomething(String eventDescription, MouseEvent e) {
		System.out.println(eventDescription);
	}

}
