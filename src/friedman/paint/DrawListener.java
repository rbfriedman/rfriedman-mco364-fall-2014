package friedman.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public interface DrawListener extends MouseMotionListener, MouseListener {
	public void drawPreview(Graphics2D g2);
}
