package friedman.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Canvas extends JComponent {
	private static final long serialVersionUID = 1L;

	private BufferedImage image;
	private BasicStroke stroke = new BasicStroke();

	private int canvasHeight;
	private int canvasWidth;

	private DrawListener listener;

	private Color color;

	public Canvas(int width, int height) {
		super();
		this.canvasHeight = height;
		this.canvasWidth = width;
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		this.color = Color.BLACK;
		Graphics g = image.getGraphics();
		setColor(Color.WHITE);
		g.fillRect(0, 0, canvasWidth, canvasHeight);
		setColor(color);
		setDrawListener(new PaintListener(this));

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g = (Graphics2D) g;
		g.setColor(color);
		g.drawImage(image, 0, 0, null);
		listener.drawPreview((Graphics2D) g);

	}

	public BufferedImage getImage() {
		return image;
	}

	public void setDrawListener(DrawListener mml) {
		removeMouseListener(listener);
		removeMouseMotionListener(listener);
		listener = mml;
		addMouseListener(listener);
		addMouseMotionListener(listener);

	}

	public void setColor(Color c) {
		// TODO Auto-generated method stub
		color = c;

	}

	public Color getColor() {
		return color;
	}

}
