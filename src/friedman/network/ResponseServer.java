package friedman.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ResponseServer {
	public static void main(String args[]) throws IOException{
		ServerSocket serverSocket = new ServerSocket(8080);
		Socket socket = serverSocket.accept();
		
		InputStream in = socket.getInputStream();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		String line ="";
		StringBuilder response =new StringBuilder();
		while((line = reader.readLine())!=null){
			response.append(line);
		}
		System.out.println(response.toString());
		OutputStream out = socket.getOutputStream();
		
		out.write("Hello World".getBytes());
		
		out.flush();
		out.close();
	}
}
