package friedman.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.event.MouseInputListener;

public class DrawRectangleListener extends PaintListener implements MouseMotionListener, MouseInputListener,
		DrawListener {
	private Rectangle r;
	private int x, y, w, h;

	public DrawRectangleListener(Canvas canvas) {
		super(canvas);
		r = new Rectangle();

	}

	@Override
	public void mouseDragged(MouseEvent me) {
		// TODO Auto-generated method stub
		w = Math.abs(me.getX() - x);
		h =Math.abs(me.getY() - y);
		int temp;
		if( me.getX() < x){
			x -=w;
		}
		if( me.getY() < y){
			y +=h;
		}
		
		
		canvas.repaint();
		super.saySomething("Dragged : [x:" + x + " y:" + y + " w:" + w + " h: " + h + "]");
		LOGGER.info(" DR Dragged");
	}

	@Override
	public void mouseMoved(MouseEvent me) {
		// TODO Auto-generated method stub

		// super.saySomething("Clicked: " + x + " " +y);
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
		this.x = me.getX();
		this.y = me.getY();
		// TODO Auto-generated method stub

		canvas.repaint();

		// resetBounds();

		LOGGER.info("Pressed");
		// super.saySomething("Clicked: " + x + " " +y);
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		// TODO Auto-generated method stub
		r.setBounds(x, y, w, h);
		Graphics2D g2 = (Graphics2D) canvas.getImage().getGraphics();
		g2.setColor(Color.BLACK);
		g2.draw(r);
		canvas.repaint();
		LOGGER.info("Released");
	}

	@Override
	public void drawPreview(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.setColor(Color.BLACK);
		g2.drawRect(x, y, w, h);
	}

	@Override
	public Shape returnShape() {
		// TODO Auto-generated method stub
		return r;
	}

	private void resetBounds() {
		// TODO Auto-generated method stub
		x = 0;
		y = 0;
		h = 0;
		w = 0;
	}

}
