package friedman.paint.drawing;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import friedman.paint.Canvas;
import friedman.paint.Shape;
import friedman.paint.messages.ShapeMessage;

public class DrawRectangleListener extends DrawShapeListener {
	
	public DrawRectangleListener(Canvas canvas) {
		super(canvas);
		int color = getCanvas().getColor().getRGB();
		shapeMessage = new ShapeMessage(Shape.RECTANGLE,x,y,w,h,color,STROKE_WIDTH,false);

	}

	@Override
	public void mouseDragged(MouseEvent me) {
		super.mouseDragged(me);
		canvas.repaint();
		super.saySomething("Dragged : [x:" + x + " y:" + y + " w:" + w + " h: "
				+ h + "]");
		LOGGER.info(" DR Dragged");
	}

	@Override
	public void mouseMoved(MouseEvent me) {
		super.mouseMoved(me);
	}

	@Override
	public void mouseClicked(MouseEvent me) {

		LOGGER.info("Clicked");
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		// TODO Auto-generated method stub
		LOGGER.info("Entered");
	}

	@Override
	public void mouseExited(MouseEvent me) {
		// TODO Auto-generated method stub
		LOGGER.info("Exited");
	}

	@Override
	public void mousePressed(MouseEvent me) {
		super.mousePressed(me);
		canvas.repaint();
		LOGGER.info("DR Pressed");
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		super.mouseReleased(me);
		Graphics2D g2 = (Graphics2D) canvas.getImage().getGraphics();
		g2.setColor(canvas.getColor());
		g2.drawRect(x, y, w, h);
		
		canvas.repaint();
		LOGGER.info(" DR Released");
	}

	@Override
	public void drawPreview(Graphics2D g2) {
		// TODO Auto-generated method stub
		super.drawPreview(g2);
		if (preview) {
			g2.drawRect(x, y, w, h);
		}
	}

}
