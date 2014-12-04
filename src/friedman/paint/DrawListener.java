package friedman.paint;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.event.MouseInputListener;

public interface DrawListener extends MouseMotionListener, MouseInputListener,  MouseListener {
	public void drawPreview(Graphics2D g2);
}
