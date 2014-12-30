package friedman.paint;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client{

	private Socket socket;
	private OutputStream output;

	public Client()  {
		try {
			socket = new Socket("localhost", 7337);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			output = socket.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	public OutputStream getOutputStream() {
		// TODO Auto-generated method stub
		return output;
	}
}
