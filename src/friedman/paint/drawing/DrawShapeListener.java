package friedman.paint.drawing;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

import friedman.paint.Canvas;
import friedman.paint.listeners.PaintListener;

public class DrawShapeListener extends PaintListener implements DrawListener {

	protected Point originPoint;
	protected Point currentPoint;
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	protected boolean preview;

	public DrawShapeListener(Canvas canvas) {
		super(canvas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		// TODO Auto-generated method stub
		currentPoint = me.getPoint();
		x = (int) Math.min(originPoint.getX(), currentPoint.getX());
		y = (int) Math.min(originPoint.getY(), currentPoint.getY());
		w = (int) Math.abs(originPoint.getX() - currentPoint.getX());
		h = (int) Math.abs(originPoint.getY() - currentPoint.getY());
	}

	@Override
	public void mousePressed(MouseEvent me) {
		resetBounds();//erases last vestiges of oldimage
		originPoint = me.getPoint();
		preview = true;
		LOGGER.info(this.getClass().toString() +" pressed");
		canvas.repaint();

	}

	@Override
	public void mouseMoved(MouseEvent me) {
		// TODO Auto-generated method stub
		originPoint = me.getPoint();
		LOGGER.info(this.getClass().toString() +" moved");
		canvas.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent me) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent me) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent me) {
		// TODO Auto-generated method stub
		preview = false;
	}

	@Override
	public void drawPreview(Graphics2D g2) {
		if (preview) {
			draw(g2);
		}
	}

	private void resetBounds() {
		// TODO Auto-generated method stub
		x = 0;
		y = 0;
		h = 0;
		w = 0;
	}
	
	public void draw(Graphics2D g2) {
		super.draw(g2);
		LOGGER.info(this.getClass().toString() + " drawing graphics object");
	}

}
