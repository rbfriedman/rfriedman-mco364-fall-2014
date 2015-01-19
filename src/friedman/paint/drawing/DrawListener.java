package friedman.paint.drawing;

import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.event.MouseInputListener;

public interface DrawListener extends  MouseInputListener {
	public void drawPreview(Graphics2D g2);
	
	public void draw(Graphics2D g2);
	
}
