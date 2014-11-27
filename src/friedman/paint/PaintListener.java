package friedman.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class PaintListener implements MouseMotionListener {
	protected static int STROKE_WIDTH = 4;
	protected static final Logger LOGGER = LogManager.getLogger(PaintListener.class);
	protected Canvas canvas;
	protected Graphics2D g;
	protected BasicStroke stroke;
	 
	
	public PaintListener(Canvas canvas) {
		super();
		this.canvas = canvas;
		g= (Graphics2D) canvas.getImage().getGraphics();
		stroke = new BasicStroke(STROKE_WIDTH);
		g.setStroke(stroke);
		g.setColor(Color.BLACK);
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
	
	public void setDrawListener(DrawListener mml){
		canvas.setDrawListener(mml);
	}

	@Override
	public void mouseDragged(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	protected void saySomething(String eventDescription) {
		System.out.println(eventDescription);
	}

}
