package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	private int port = 8000;
	private ServerSocket serverSocket;

	public EchoServer() throws IOException {
		serverSocket = new ServerSocket(port);
		System.out.println("服务器启动.........");
	}
	
	public String Echo(String msg){
		return "echo:"+msg;
	}

	public PrintWriter getWriter(Socket socket) throws IOException {
		OutputStream os = socket.getOutputStream();
		return new PrintWriter(os, true);
	}

	public BufferedReader getReader(Socket socket) throws IOException {
		InputStream is = socket.getInputStream();
		return new BufferedReader(new InputStreamReader(is));
	}

	public void Service(){
		A:while(true){
			Socket socket = null;
			try{
				socket = serverSocket.accept();
				System.out.println("New Connection accepted:"+socket.getInetAddress()+":"+socket.getPort());
				BufferedReader br = getReader(socket);
				PrintWriter pw = getWriter(socket);
				
				String msg = null;
				while((msg=br.readLine())!=null){
					System.out.println(Echo(msg));
					pw.println(Echo(msg));
					if(msg.equals("bye")){
						break A;
					}
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
	}

	public static void main(String args[]) throws IOException {
		new EchoServer().Service();
	}
}