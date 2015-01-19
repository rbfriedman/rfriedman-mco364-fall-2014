package friedman.paint;

import java.awt.Graphics2D;
import java.io.PrintWriter;

import friedman.paint.messages.PaintMessage;
import friedman.paint.messages.PaintMessageFactory;

public class LoopbackNetworkModule implements NetworkModule {
	private Canvas canvas;
	private PaintMessageFactory pmf;

	public LoopbackNetworkModule(Canvas canvas) {
		this.canvas = canvas;
		this.pmf = new PaintMessageFactory(canvas);
	}

	@Override
	public void sendMessage(PaintMessage pm) {
		// TODO Auto-generated method stub
		PaintMessage msg = pmf.getMessage(pm.toString()); 
		msg.apply((Graphics2D) canvas.getImage().getGraphics());
		canvas.repaint();
		LOGGER.info(pm.toString());

	}

}
