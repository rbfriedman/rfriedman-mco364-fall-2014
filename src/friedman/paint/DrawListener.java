package friedman.paint;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public interface DrawListener extends MouseMotionListener, MouseListener {
	public void drawPreview(Graphics2D g2);
	public Shape returnShape();
}
