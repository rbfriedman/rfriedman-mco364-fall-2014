package friedman.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PaintListener implements DrawListener {
	protected static int STROKE_WIDTH = 4;
	protected static final Logger LOGGER = LogManager
			.getLogger(PaintListener.class);
	protected Canvas canvas;
	protected Graphics2D g;
	protected BasicStroke stroke;

	public PaintListener(Canvas canvas) {
		super();
		this.canvas = canvas;
		g = (Graphics2D) canvas.getImage().getGraphics();
		stroke = new BasicStroke(STROKE_WIDTH);
		g.setStroke(stroke);
		setColor(Color.BLACK);
	}

	public void setColor(Color c) {
		g.setColor(c);
		canvas.setColor(c);
		canvas.repaint();
		LOGGER.info("Color set to " + c);
	}

	public void increaseStrokeWidth() {
		if (STROKE_WIDTH < 50) {
			STROKE_WIDTH += 1;
			canvas.repaint();
			((Graphics2D) g).setStroke(new BasicStroke(STROKE_WIDTH,
					BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		}
	}

	public void decreaseStrokeWidth() {
		if (STROKE_WIDTH > 0) {
			STROKE_WIDTH -= 1;
			System.out.print("Stroke : " + STROKE_WIDTH);
			canvas.repaint();
			((Graphics2D) g).setStroke(new BasicStroke(STROKE_WIDTH,
					BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		}
	}

	public int getStrokeWidth() {
		return STROKE_WIDTH;
	}

	public void clearScreen() {
		//Graphics2D graphics = canvas.getImage().createGraphics();
		g.setPaint(Color.WHITE);
		g.fillRect(0, 0, canvas.getImage().getWidth(), canvas.getImage()
				.getHeight());
		
		canvas.repaint();

	}

	public void setDrawListener(DrawListener mml) {
		canvas.setDrawListener(mml);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	protected void saySomething(String eventDescription) {
		System.out.println(eventDescription);
	}

	protected Canvas getCanvas() {
		return canvas;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawPreview(Graphics2D g2) {
		// TODO Auto-generated method stub

	}

}
