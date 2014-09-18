package friedman.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;


public class NetworkRequest {

	public static void main(String args[]) throws IOException{
		Socket socket = new Socket("www.amazon.com",80);
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		String request = "GET /index.html\n\n";
		out.write(request.getBytes());
		out.flush();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line ="";
		StringBuilder response =new StringBuilder();
		while((line = reader.readLine())!=null){
			response.append(line);
		}
		System.out.println(response.toString());
		
		
		
	}
}
