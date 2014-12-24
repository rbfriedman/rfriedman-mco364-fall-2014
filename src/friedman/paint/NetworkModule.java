package friedman.paint;

import friedman.paint.messages.PaintMessage;

public interface NetworkModule {
	
	public void sendMessage(PaintMessage pm);

}
