package friedman.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Random;

public class PaintListener implements MouseMotionListener {
	private static int STROKE_WIDTH = 4;
	private Canvas canvas;
	private Graphics2D g;
	private int x1;
	private int y1;
	private int y2;
	private int x2;
	private boolean canvasClicked;
	private BasicStroke stroke;

	public PaintListener(Canvas canvas) {
		this.canvas = canvas;
		g = (Graphics2D) canvas.getImage().getGraphics();
		stroke = new BasicStroke(STROKE_WIDTH);
		g.setStroke(stroke);
		g.setColor(Color.BLACK);
	}
	public void mouseDragged(MouseEvent e) {
		if (!isClicked()) {
			setPointOrigin(e.getX(), e.getY());
			setPointNext(e.getX(), e.getY());
			setClicked(true);
		} else {
			setPointOrigin(getNextPoint()[0],
					getNextPoint()[1]);
			setPointNext(e.getX(), e.getY());
		}
		drawLine();
		canvas.repaint();

	}

	public void mouseMoved(MouseEvent e) {
		setClicked(false);

	}

	private void saySomething(String eventDescription, MouseEvent e) {
		System.out.println(eventDescription);
	}

	public void setPointOrigin(int x1, int y1) {
		this.x1 = x1;
		this.y1 = y1;
	}

	public void setPointNext(int x2, int y2) {
		this.x2 = x2;
		this.y2 = y2;
	}



	public void setClicked(boolean b) {
		canvasClicked = b;

	}

	public boolean isClicked() {
		// TODO Auto-generated method stub
		return canvasClicked;
	}

	public void drawLine() {
		g.drawLine(x1, y1, x2, y2);

	}

	public int[] getNextPoint() {
		return new int[] { x2, y2 };
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
