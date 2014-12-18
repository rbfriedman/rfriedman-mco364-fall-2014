package friedman.paint.drawing;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;

import friedman.paint.Canvas;

public class FillRectangleListener extends DrawShapeListener {

	public FillRectangleListener(Canvas canvas) {
		super(canvas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		super.mouseDragged(me);
		canvas.repaint();
		LOGGER.info("FR Dragged");

	}

	@Override
	public void mouseMoved(MouseEvent me) {
		super.mouseMoved(me);

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
	public void mousePressed(MouseEvent me) {
		// TODO Auto-generated method stub
		super.mousePressed(me);
		canvas.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		super.mouseReleased(me);
		Graphics2D g2 = (Graphics2D) canvas.getImage().getGraphics();
		draw(g2);
		canvas.repaint();
	}
	
	

	@Override
	public void draw(Graphics2D g2) {
		super.draw(g2);
		g2.fillRect(x, y, w, h);
	}

	@Override
	public void drawPreview(Graphics2D g2) {
		super.drawPreview(g2);
		if (preview) {
			draw(g2);
		}
	}

}
