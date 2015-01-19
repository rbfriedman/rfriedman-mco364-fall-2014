package friedman.paint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import friedman.paint.messages.PaintMessage;

public interface NetworkModule {
	public static final Logger LOGGER = LogManager.getLogger(NetworkModule.class);
	public void sendMessage(PaintMessage pm);

}
