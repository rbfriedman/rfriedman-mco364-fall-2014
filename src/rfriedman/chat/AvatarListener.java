package rfriedman.chat;

import java.io.IOException;

public interface AvatarListener {
	public final String USER_AGENT = "Mozilla/5.0";
	
	public void sendGet() throws IOException;
}
