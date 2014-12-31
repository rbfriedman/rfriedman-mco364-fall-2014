package friedman.paint;

import java.io.PrintWriter;

import friedman.paint.messages.PaintMessage;

public class OnlineNetworkModule implements NetworkModule {

	private Canvas canvas;
	
	public OnlineNetworkModule(Canvas canvas){
		this.canvas = canvas;
	}
	@Override
	public void sendMessage(PaintMessage pm) {
		// TODO Auto-generated method stub
		LOGGER.info(pm.toString());
		String message = pm.toString();
		PrintWriter writer = canvas.getPrintWriter();
		writer.print(message);
		writer.flush();
	}

}
