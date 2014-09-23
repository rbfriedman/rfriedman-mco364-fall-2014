package friedman.network;

import java.io.IOException;
import java.io.OutputStream;

public class ResponseThread extends Thread {
	private int numberVisitor;
	private OutputStream out;

	public ResponseThread(int numberVisitor, OutputStream out) {
		this.numberVisitor = numberVisitor;
		this.out = out;
	}

	public void run() {

		String response = "<h5>This is the " + numberVisitor
				+ "st request</h5>";
		try {
			out.write("HTTP/1.1 200 OK\n".getBytes());
			out.write("Content-Type: text/html; charset=utf-8\n".getBytes());
			out.write(("Content-Length: " + response.length() + "\n\n")
					.getBytes());
			out.write(response.getBytes());
			out.flush();
			out.close();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}

	}
}
