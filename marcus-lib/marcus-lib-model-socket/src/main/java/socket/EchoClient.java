package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient{
	private int port = 8000;
	private String host = "localhost";
	private Socket socket;
	
	public EchoClient() throws IOException{
		socket = new Socket(host, port);
	}
	
	public BufferedReader getReader(Socket socket) throws IOException{
		InputStream is = socket.getInputStream();
		return new BufferedReader(new InputStreamReader(is));
	}
	
	public PrintWriter getWriter(Socket socket) throws IOException{
		OutputStream os = socket.getOutputStream();
		return new PrintWriter(os, true);
	}
	
	public void talk(){
		try{
			BufferedReader br = getReader(socket);
			PrintWriter pw = getWriter(socket);
			BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));
			String msg = null;
			while((msg = localReader.readLine()) != null){
				pw.println(msg);
				System.out.println(br.readLine());
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(socket!=null){
					socket.close();
				}
			}catch(IOException e1){
				e1.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]) throws IOException{
		new EchoClient().talk();
	}
}