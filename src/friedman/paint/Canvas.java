package friedman.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Canvas extends JComponent {
	private static final long serialVersionUID = 1L;
	private int STROKE_WIDTH = 4;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private Graphics2D g;

	private BufferedImage image;
	private boolean canvasClicked;
	private BasicStroke stroke = new BasicStroke();
	
	private int canvasHeight;
	private int canvasWidth;

	public Canvas(int width, int height) {
		super();
		this.canvasHeight = height;
		this.canvasWidth = width;
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		g = (Graphics2D) image.getGraphics();
		stroke = new BasicStroke(STROKE_WIDTH);
		g.setStroke(stroke);
		g.setColor(Color.BLACK);

	}

	public void setPointOrigin(int x1, int y1) {
		this.x1 = x1;
		this.y1 = y1;
	}

	public void setPointNext(int x2, int y2) {
		this.x2 = x2;
		this.y2 = y2;
	}

	protected void paintComponent(Graphics g) {
		g = (Graphics2D) g;

		g.drawImage(image, 0, 0, null);

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

	}

	public int[] getNextPoint() {
		return new int[] { x2, y2 };
	}

	public void setColor(Color c) {
		g.setColor(c);
		repaint();
	}

	public void increaseStrokeWidth() {
		if (STROKE_WIDTH < 50) {
			STROKE_WIDTH += 1;
			repaint();
			((Graphics2D) g).setStroke(new BasicStroke(STROKE_WIDTH,BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		}
	}

	public void decreaseStrokeWidth() {
		if (STROKE_WIDTH > 0) {
			STROKE_WIDTH -= 1;
			System.out.print("Stroke : " + STROKE_WIDTH);
			repaint();
			((Graphics2D) g).setStroke(new BasicStroke(STROKE_WIDTH,BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		}
	}

}
