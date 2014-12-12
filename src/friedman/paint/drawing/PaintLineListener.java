package friedman.paint.drawing;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import friedman.paint.Canvas;
import friedman.paint.PaintListener;

public class PaintLineListener extends PaintListener implements
		MouseMotionListener {

	private int x1;
	private int y1;
	private int y2;
	private int x2;
	private boolean canvasClicked;

	public PaintLineListener(Canvas canvas) {
		super(canvas);
	}

	public void mouseDragged(MouseEvent e) {
		if (!isClicked()) {
			setPointOrigin(e.getX(), e.getY());
			setPointNext(e.getX(), e.getY());
			setClicked(true);
		} else {
			setPointOrigin(getNextPoint()[0], getNextPoint()[1]);
			setPointNext(e.getX(), e.getY());
		}
		drawLine();
		g.setColor(canvas.getColor());
		canvas.repaint();
	

	}

	public void mouseMoved(MouseEvent e) {
		setClicked(false);

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
		LOGGER.info("Line Drawn");

	}

	public int[] getNextPoint() {
		return new int[] { x2, y2 };
	}

}
