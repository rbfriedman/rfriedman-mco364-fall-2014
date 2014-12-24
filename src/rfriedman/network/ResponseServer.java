package friedman.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ResponseServer{
	private int visitorCount;
	private ServerSocket serverSocket;

	public ResponseServer() throws IOException {
		visitorCount =0;
		serverSocket = new ServerSocket(8080);
		startServer();
		
	}
	
	public void startServer() throws IOException{
		while (true) {
			Socket socket = serverSocket.accept();

			InputStream in = socket.getInputStream();

			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			String line = "";
			if(null != (line = reader.readLine()) && !line.contains(".ico")){
				visitorCount++;
				do {
					System.out.println(line);
				}while(	 !"".equals((line = reader.readLine())));
				System.out.println(visitorCount);
			}

			OutputStream out = socket.getOutputStream();
			new ResponseThread(visitorCount,out).start();;
		

			
		}	

		
	}
	public static void main(String args[]) {
		try{
		ResponseServer myResponseServer = new ResponseServer();
		}catch(IOException io){
			io.printStackTrace();
		}
		
	}


	
}
