package friedman.paint.messages;

import java.awt.Color;
import java.awt.Graphics2D;

import friedman.paint.Canvas;

public class ClearMessage implements PaintMessage {
	private Canvas canvas;
	public ClearMessage(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public String toString() {
		return "CLEAR\n";
	}

	@Override
	public void apply(Graphics2D g) {
		g.setPaint(Color.WHITE);
		g.fillRect(0, 0, canvas.getImage().getWidth(), canvas.getImage()
				.getHeight());
		
		canvas.repaint();
		g.setPaint(Color.WHITE);

	}

}