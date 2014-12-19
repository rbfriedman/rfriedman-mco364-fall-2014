package friedman.paint.drawing;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;

import friedman.paint.Canvas;

public class FillRectangleListener extends DrawShapeListener {


	public FillRectangleListener(Canvas canvas) {
		super(canvas);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void mouseReleased(MouseEvent me) {
		super.mouseReleased(me);
		Graphics2D g2 = (Graphics2D) canvas.getImage().getGraphics();
		draw(g2);
		canvas.repaint();
	}

	@Override
	public void draw(Graphics2D g2) {
		super.draw(g2);
		g2.fillRect(x, y, w, h);
	}

	@Override
	public void drawPreview(Graphics2D g2) {
		super.drawPreview(g2);
		if (preview) {
			draw(g2);
		}
	}

}
