package friedman.paint.messages;

import java.awt.Graphics2D;

import friedman.paint.Canvas;
import friedman.paint.Shape;

public class PaintMessageFactory {
	private Canvas canvas;
	public PaintMessageFactory(Canvas canvas) {
		this.canvas = canvas;
	}


	public String sendMessage(PaintMessage pm) {
		return pm.toString();
	}
	//port 3773  192.168.117.107


	public PaintMessage getMessage(String s) {
		
		String[] messageTokens = s.split(" ");
		PaintMessage pm = null;
		PaintMessageType pmt = PaintMessageType.valueOf(messageTokens[0]);
		switch (pmt) {
		case BUCKET_FILL:
			pm = new BucketFillMessage(Integer.valueOf(messageTokens[1]), Integer.valueOf(messageTokens[2]),
					Integer.valueOf(messageTokens[3]),canvas);
			break;
		case CLEAR:
			pm = new ClearMessage(canvas);
			break;
		case LINE:
			pm = new LineMessage(Integer.valueOf(messageTokens[1]), Integer.valueOf(messageTokens[2]),
					Integer.valueOf(messageTokens[3]), Integer.valueOf(messageTokens[4]),
					Integer.valueOf(messageTokens[5]), Integer.valueOf(messageTokens[6]));
			break;
		case SHAPE:
			pm = new ShapeMessage(Shape.valueOf(messageTokens[1]), Integer.valueOf(messageTokens[2]),
					Integer.valueOf(messageTokens[3]), Integer.valueOf(messageTokens[4]),
					Integer.valueOf(messageTokens[5]), Integer.valueOf(messageTokens[6]),
					Integer.valueOf(messageTokens[7]), Boolean.valueOf(messageTokens[8]));
			break;
			
		}
		return pm;
	}
}