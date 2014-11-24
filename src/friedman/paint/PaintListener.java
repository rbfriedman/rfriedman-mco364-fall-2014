package friedman.paint;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Random;

public class PaintListener implements MouseMotionListener {
	private Canvas canvas;
	private Color paintColor;
	private Random randomGen;

	public PaintListener(Canvas canvas) {
		this.canvas = canvas;
		randomGen = new Random();
	}

	public void mouseDragged(MouseEvent e) {
		if (!canvas.isClicked()) {
			canvas.setPointOrigin(e.getX(), e.getY());
			canvas.setPointNext(e.getX(), e.getY());
			canvas.setClicked(true);
		} else {
			canvas.setPointOrigin(canvas.getNextPoint()[0], canvas.getNextPoint()[1]);
			canvas.setPointNext(e.getX(), e.getY());
		}
		canvas.drawLine();
		canvas.repaint();

	}

	public void mouseMoved(MouseEvent e) {
		canvas.setClicked(false);
		canvas.setColor(getRandomColor());

	}

	private void saySomething(String eventDescription, MouseEvent e) {
		System.out.println(eventDescription);
	}

	private Color getRandomColor() {
		int a = 50 + randomGen.nextInt(150);
		int b = 100 + randomGen.nextInt(150);
		int c = 100 + randomGen.nextInt(150);
		return new Color(a, b, c);
	}

}
