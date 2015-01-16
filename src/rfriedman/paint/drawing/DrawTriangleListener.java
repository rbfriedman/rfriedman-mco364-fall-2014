package rfriedman.paint.drawing;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

import rfriedman.paint.Canvas;

public class DrawTriangleListener extends DrawShapeListener {
/*
 * To be implemented in a further edition
 */
	public DrawTriangleListener(Canvas canvas) {
		super(canvas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		super.mouseDragged(me);
		canvas.repaint();
		LOGGER.info("DT Dragged");
	}

	@Override
	public void mouseMoved(MouseEvent me) {
		super.mouseMoved(me);
		canvas.repaint();
		LOGGER.info("DT Moved");

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
		draw(g2);
		canvas.repaint();
		LOGGER.info(" DO Released");

	}

	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		boolean horizontalFlip = false;
		boolean verticalFlip = false;
		if (h == y) {
			horizontalFlip = true;
		}
		if( w == x){
			verticalFlip = true;
		}
		super.draw(g2);
		Point point2 = new Point(x - w, y);
		Point point3 = new Point(x - (w / 2), y + h);
		if (horizontalFlip) {
			point2.x = x + w;
			point3.setLocation(new Point(x + (w / 2), y - h));
		} 
		if(verticalFlip){
			point2.y = - point2.y;
			point3.y = -point3.y;
			
		}
		g2.drawLine(point2.x, point2.y,x,y);
		g2.drawLine(point3.x, point3.y,x, y);
		g2.drawLine(point2.x, point2.y, point3.x, point3.y);

	}

	@Override
	public void drawPreview(Graphics2D g2) {
		super.drawPreview(g2);
		if (preview) {
			draw(g2);
		}

	}

}
