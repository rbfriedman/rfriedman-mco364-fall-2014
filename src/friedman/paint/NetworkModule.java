package friedman.paint;

import org.apache.logging.log4j.LogManager;

import friedman.paint.messages.PaintMessage;

public interface NetworkModule {
	public static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(NetworkModule.class);
	public void sendMessage(PaintMessage pm);

}
