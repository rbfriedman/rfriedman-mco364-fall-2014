package friedman.paint;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private Socket socket;
	private OutputStream output;

	public Client() throws UnknownHostException, IOException {
		socket = new Socket("192.168.117.46", 3773);
		output = socket.getOutputStream();
	}

	public void sendMessage(String message) throws IOException {
		
		output.write(message.toString().getBytes());
		output.flush();
	}

	public OutputStream getOutputStream() {
		// TODO Auto-generated method stub
		return output;
	}
}
