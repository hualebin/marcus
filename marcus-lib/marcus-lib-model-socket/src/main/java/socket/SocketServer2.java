package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class SocketServer2 {
	private ServerSocket serverSocket;
	private static int port = 8000;
	
	public SocketServer2() throws IOException{
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(100);
		System.out.println("服务器启动成功了..............");
	}
	
	public PrintWriter getWriter(Socket socket) throws IOException {
		OutputStream os = socket.getOutputStream();
		return new PrintWriter(os, true);
	}

	public BufferedReader getReader(Socket socket) throws IOException {
		InputStream is = socket.getInputStream();
		return new BufferedReader(new InputStreamReader(is));
	}
	
	public void service(){
		A:while(true){
			Socket socket = null;
			PrintWriter pw = null;
			BufferedReader br = null;
			try {
				socket = serverSocket.accept();
				pw = getWriter(socket);
				br = getReader(socket);
				
				String msg = null;
				socket.setSoTimeout(10);
				while((msg=br.readLine())!=null){
					System.out.println("来自客户端的消息" + msg);
					pw.println("服务器回复响应" + msg);
					if(msg.equals("bye")){
						break A;
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try{
					if(pw != null){
						pw.close();
					}
					if(br != null){
						br.close();
					}
					if(socket != null){
						socket.close();
					}
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main (String args[]) throws IOException{
		new SocketServer2().service();
	}

}
