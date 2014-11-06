package friedman.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Canvas extends JComponent {
	private static final long serialVersionUID = 1L;
	private static final int STROKE_WIDTH = 4;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private Graphics2D g;

	private BufferedImage image;
	private boolean canvasClicked;

	public Canvas() {
		super();
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		g = (Graphics2D) image.getGraphics();
		g.setColor(Color.BLACK);
		((Graphics2D) g).setStroke(new BasicStroke(STROKE_WIDTH));
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

		((Graphics2D) g).setStroke(new BasicStroke(30));
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
	
	public int[] getNextPoint(){
		return new int[]{x2,y2};
	}
	
	public void setColor(Color c){
		g.setColor(c);
	}
	
	

}
