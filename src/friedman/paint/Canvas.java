package friedman.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

import javax.swing.JComponent;

public class Canvas extends JComponent implements MouseMotionListener {
	private static final long serialVersionUID = 1L;
	private Path2D.Double path;
	private Point2D.Double originalPoint;
	private Point2D.Double nextPoint;
	private boolean canvasClicked;

	public Canvas() {
		super();
		addMouseMotionListener(this);
		path = new Path2D.Double();
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(10));
		g2.setColor(Color.BLACK);
		g2.draw(path);
		

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (!canvasClicked) {
			originalPoint = new Point2D.Double(e.getX(), e.getY());
			nextPoint = new Point2D.Double(e.getX(), e.getY());
			
			canvasClicked = true;
		} else {
			originalPoint = nextPoint;
			nextPoint = new Point2D.Double(e.getX(), e.getY());
		}
		path.moveTo(originalPoint.getX(), originalPoint.getY());
		path.lineTo(nextPoint.getX(), nextPoint.getY());
		repaint();

		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		canvasClicked = false;
	}

	void saySomething(String eventDescription, MouseEvent e) {
		System.out.println(eventDescription);
	}

}
