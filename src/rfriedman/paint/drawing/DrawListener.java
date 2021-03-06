package rfriedman.paint.drawing;

import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.event.MouseInputListener;

public interface DrawListener extends MouseMotionListener, MouseInputListener,  MouseListener,  {
	public void drawPreview(Graphics2D g2);

	void draw(Graphics2D g2);
}
