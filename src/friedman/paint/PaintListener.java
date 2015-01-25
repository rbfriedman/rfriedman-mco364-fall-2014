package friedman.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import friedman.paint.drawing.DrawListener;
import friedman.paint.messages.PaintMessage;

public class PaintListener implements DrawListener {
	protected static int STROKE_WIDTH = 4;
	protected static final Logger LOGGER = LogManager
			.getLogger(PaintListener.class);
	protected Canvas canvas;
	protected Graphics2D g;
	protected BasicStroke stroke;
	protected NetworkModule networkModule;

	public PaintListener(Canvas canvas) {
		super();
		this.canvas = canvas;
		g = (Graphics2D) canvas.getImage().getGraphics();
		stroke = new BasicStroke(STROKE_WIDTH);
		g.setStroke(stroke);
		canvas.setCursor (Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
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



	public NetworkModule getNetworkModule(){
		return networkModule;
	}

	public void setNetworkModule(NetworkModule networkModule) {
		this.networkModule = networkModule;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawPreview(Graphics2D g2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		
	}


}
