package friedman.paint;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DrawRectangleListener implements MouseMotionListener, DrawListener {
	private Rectangle r = new Rectangle();
	private int x,y,w,h;
	private Graphics2D g2;

	
	
	@Override
	public void mouseDragged(MouseEvent me) {
		// TODO Auto-generated method stub
		w = me.getX();
		h = me.getY();
		drawPreview(g2);
	}

	@Override
	public void mouseMoved(MouseEvent me) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent me) {
		// TODO Auto-generated method stub
		this.x = me.getX();
		this.y = me.getY();
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
		
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawPreview(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.drawRect(x, y, w, h);
	}

}
