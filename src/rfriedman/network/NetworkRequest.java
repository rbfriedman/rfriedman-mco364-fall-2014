package rfriedman.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;


public class NetworkRequest {

	public static void main(String args[]) throws IOException{
		Socket socket = new Socket("192.168.117.113",8080);
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		out.write("Hello World".getBytes());
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
