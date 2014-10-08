package friedman.chat;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.UnknownHostException;

import org.junit.Test;

import rfriedman.chat.ChatClient;

public class ChatClientTest {

	@Test
	public void test() throws UnknownHostException, IOException {
		ChatClient m = new ChatClient("Rena");
		m.setVisible(true);
		//ChatClient a = new ChatClient("Julia");
		while(true){
			
		}
	}

}
