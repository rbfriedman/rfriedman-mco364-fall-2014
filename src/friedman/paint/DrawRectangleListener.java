package friedman.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import org.apache.logging.log4j.core.Logger;

public class DrawRectangleListener extends PaintListener implements MouseMotionListener, DrawListener {
	private Rectangle r;
	private int x,y,w,h;
	private Graphics2D g2;
	
	public DrawRectangleListener(Canvas canvas) {
		super(canvas);
		r = new Rectangle();
		g2 = (Graphics2D) canvas.getImage().getGraphics();
		
		
	}



	
	
	@Override
	public void mouseDragged(MouseEvent me) {
		// TODO Auto-generated method stub
		
		h = me.getX()+ x;
		w = me.getY() + y;
		drawPreview(g2);
		super.saySomething("Dragged : [x:"+ x +" y:"+  y +" w:" +w + " h: " + h +"]");
		LOGGER.info(" DR Dragged");
	}

	@Override
	public void mouseMoved(MouseEvent me) {
		// TODO Auto-generated method stub
		this.x = me.getX();
		this.y = me.getY();
		//super.saySomething("Clicked: " + x + " " +y);
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
		// TODO Auto-generated method stub
		this.x = me.getX();
		this.y = me.getY();
		
		LOGGER.info("Pressed");
		//super.saySomething("Clicked: " + x + " " +y);
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		// TODO Auto-generated method stub
		//g2.drawRect(x, y, w, h);
		canvas.repaint();
		LOGGER.info("Released");
	}

	@Override
	public void drawPreview(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.drawRect(x, y, w, h);
		canvas.repaint();
	}

	@Override
	public Shape returnShape() {
		// TODO Auto-generated method stub
		return r;
	}

}
