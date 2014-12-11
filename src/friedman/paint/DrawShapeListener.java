package friedman.paint;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

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

	}

	@Override
	public void mouseMoved(MouseEvent me) {
		// TODO Auto-generated method stub
		originPoint = me.getPoint();
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

		//g2.setColor(canvas.getColor());

	}

	private void resetBounds() {
		// TODO Auto-generated method stub
		x = 0;
		y = 0;
		h = 0;
		w = 0;
	}

}
