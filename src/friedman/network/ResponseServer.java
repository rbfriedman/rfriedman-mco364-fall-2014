package friedman.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ResponseServer {
	public static void main(String args[]) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8080);
		

		int counter = 0;
		while (true) {
			Socket socket = serverSocket.accept();

			InputStream in = socket.getInputStream();

			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			String line = "";
			if(null != (line = reader.readLine()) && !line.contains(".ico")){
				counter++;
				do {
					System.out.println(line);
				}while(	 !"".equals((line = reader.readLine())));
				System.out.println(counter);
			}

			OutputStream out = socket.getOutputStream();
			
			String response = "<h5>This is the "+counter+"st request</h2>";
			out.write(response.getBytes());
			out.write("HTTP/1.1 200 OK\n".getBytes());
			out.write("Content-Type: text/html); charset=utf-8\n".getBytes());
			out.write(("Content-Length: " + response.length() + " ").getBytes());
			out.flush();
			out.close();
			
			
			
			
		}
		
	}
	
}
