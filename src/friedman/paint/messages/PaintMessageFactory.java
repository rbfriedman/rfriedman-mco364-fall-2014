package friedman.paint.messages;

import friedman.paint.Canvas;
import friedman.paint.Shape;

public class PaintMessageFactory {
	private Canvas canvas;
	public PaintMessageFactory(Canvas canvas){
		this.canvas = canvas;
	}

	public String sendMessage(PaintMessage pm) {
		return pm.toString();
	}


	public PaintMessage getMessage(String s) {
		s = s.substring(0,s.length()-1);//removing new line char
		String[] messageTokens = s.split(" ");
		PaintMessage pm = null;
		PaintMessageType pmt = PaintMessageType.valueOf(messageTokens[0]);
		switch (pmt) {
		case BUCKET_FILL:
			pm = new BucketFillMessage(Integer.valueOf(messageTokens[1]), Integer.valueOf(messageTokens[2]),
					Integer.valueOf(messageTokens[3]),canvas);
			break;
		case CLEAR:
			pm = new ClearMessage();
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
