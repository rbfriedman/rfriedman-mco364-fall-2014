package friedman.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseMotionListener;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.views.AbstractView;

public class PaintListener  {
	protected static int STROKE_WIDTH = 4;
	protected Canvas canvas;
	protected Graphics2D g;
	
	public PaintListener(Canvas canvas) {
		super();
		this.canvas = canvas;
	}

	public void setColor(Color c) {
		g.setColor(c);
		canvas.repaint();
	}

	public void increaseStrokeWidth() {
		if (STROKE_WIDTH < 50) {
			STROKE_WIDTH += 1;
			canvas.repaint();
			((Graphics2D) g).setStroke(new BasicStroke(STROKE_WIDTH,BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		}
	}

	public void decreaseStrokeWidth() {
		if (STROKE_WIDTH > 0) {
			STROKE_WIDTH -= 1;
			System.out.print("Stroke : " + STROKE_WIDTH);
			canvas.repaint();
			((Graphics2D) g).setStroke(new BasicStroke(STROKE_WIDTH,BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		}
	}
	
	public int getStrokeWidth() {
		return STROKE_WIDTH;
	}
	
	public void clearScreen(){
		Color previousColor = g.getColor();
		g.setColor(Color.WHITE);
		g.fillRect(0,0,canvas.getWidth(), canvas.getHeight());
		canvas.repaint();
		g.setColor(previousColor);
		
	}

}
