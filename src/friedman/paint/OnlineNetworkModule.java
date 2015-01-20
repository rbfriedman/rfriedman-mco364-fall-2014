package friedman.paint;

import java.io.PrintWriter;

import friedman.paint.messages.PaintMessage;

public class OnlineNetworkModule implements NetworkModule {

	private Canvas canvas;
	private PrintWriter writer;

	public OnlineNetworkModule(Canvas canvas) {
		this.canvas = canvas;
		writer = canvas.getPrintWriter();
	}

	@Override
	public void sendMessage(PaintMessage pm) {
		LOGGER.info(pm.toString());
		writer.print(pm.toString());
		writer.flush();
	}

}
