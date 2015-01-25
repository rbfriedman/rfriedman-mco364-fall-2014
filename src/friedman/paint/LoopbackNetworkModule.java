package friedman.paint;

import java.awt.Graphics2D;

import friedman.paint.messages.PaintMessage;
import friedman.paint.messages.PaintMessageFactory;

public class LoopbackNetworkModule implements NetworkModule{
	private Canvas canvas;
	private PaintMessageFactory pmf;
	
	public LoopbackNetworkModule(Canvas canvas){
		this.canvas = canvas;
		this.pmf = new PaintMessageFactory(canvas);
	}
	@Override
	public void sendMessage(PaintMessage pm) {
		// TODO Auto-generated method stub
		String message = pm.toString();
		message = message.substring(0,message.length()-1);//removing new line char
		PaintMessage msg = pmf.getMessage(message); 
		msg.apply((Graphics2D) canvas.getImage().getGraphics());
		canvas.repaint();
	}

}
