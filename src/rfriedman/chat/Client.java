package rfriedman.chat;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String args[]) throws IOException{
		Socket socket = new Socket("192.168.117.113",8080);
		//InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		Scanner myScanner = new Scanner(System.in);
		String line = new String("");
		while((line =myScanner.nextLine())!=""){
			out.write(line.getBytes());
			
		}
		out.flush();
		
		/*BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line ="";
		StringBuilder response =new StringBuilder();
		while((line = reader.readLine())!=null){
			response.append(line);
		}
		System.out.println(response.toString());
		*/
		
		
	}
}
