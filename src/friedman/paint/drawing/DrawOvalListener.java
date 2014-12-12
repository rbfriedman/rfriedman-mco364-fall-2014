package friedman.paint.drawing;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;

import friedman.paint.Canvas;

public class DrawOvalListener extends DrawShapeListener {

	public DrawOvalListener(Canvas canvas) {
		super(canvas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		super.mouseDragged(me);
		canvas.repaint();
		LOGGER.info("DO Dragged");
	}

	@Override
	public void mouseMoved(MouseEvent me) {
		super.mouseMoved(me);
		canvas.repaint();
		LOGGER.info("DO Moved");

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
		super.mousePressed(me);
		canvas.repaint();
		LOGGER.info("DO Pressed");

	}

	@Override
	public void mouseReleased(MouseEvent me) {
		super.mouseReleased(me);
		Graphics2D g2 = (Graphics2D) canvas.getImage().getGraphics();
		g2.setColor(canvas.getColor());
		g2.drawOval(x, y, w, h);
		canvas.repaint();
		LOGGER.info(" DO Released");

	}

	@Override
	public void drawPreview(Graphics2D g2) {
		super.drawPreview(g2);
		if (preview) {
			g2.drawOval(x, y, w, h);
		}

	}

}
