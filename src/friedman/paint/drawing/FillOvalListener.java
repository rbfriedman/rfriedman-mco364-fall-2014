package friedman.paint.drawing;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import friedman.paint.Canvas;
import friedman.paint.Shape;
import friedman.paint.messages.ShapeMessage;

public class FillOvalListener extends DrawShapeListener {

	public FillOvalListener(Canvas canvas) {
		super(canvas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		super.mouseDragged(me);
		canvas.repaint();
		LOGGER.info("FO Dragged");
	}

	@Override
	public void mouseMoved(MouseEvent me) {
		super.mouseMoved(me);
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
	public void mousePressed(MouseEvent me) {
		super.mousePressed(me);
		canvas.repaint();
		LOGGER.info("DR Pressed");

	}

	@Override
	public void mouseReleased(MouseEvent me) {
		// TODO Auto-generated method stub
		super.mouseReleased(me);
		getNetworkModule().sendMessage(new ShapeMessage(Shape.OVAL, x, y, w, h, canvas.getPaintColor().getRGB(), STROKE_WIDTH, true));
		canvas.repaint();
		LOGGER.info("FO Released");
	}
	
	@Override
	public void draw(Graphics2D g2){
		super.draw(g2);
		g2.fillOval(x, y, w, h);
		
	}

	@Override
	public void drawPreview(Graphics2D g2) {
		// TODO Auto-generated method stub
		super.drawPreview(g2);
		if (preview) {
			draw(g2);
		}
	}
	
	

}