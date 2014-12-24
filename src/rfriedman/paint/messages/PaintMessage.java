package rfriedman.paint.messages;

import java.awt.Graphics2D;

public interface PaintMessage {
	public void apply(Graphics2D g2);
}
