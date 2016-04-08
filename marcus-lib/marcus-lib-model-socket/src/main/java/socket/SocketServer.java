package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 单线程服务器
 * @author Administrator
 *
 */
public class SocketServer {
	
	private ServerSocket serverSocket;
	private static int port = 8000;
	
	public SocketServer() throws IOException{
		serverSocket = new ServerSocket(port);
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
	
	public void service() {
		try {
            while(true) {
                Socket socket = serverSocket.accept();

                //下面我们收取信息
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                Integer sourcePort = socket.getPort();
                int maxLen = 2048;
                byte[] contextBytes = new byte[maxLen];
                //这里也会被阻塞，直到有数据准备好
                int realLen = in.read(contextBytes, 0, maxLen);
                //读取信息
                String message = new String(contextBytes , 0 , realLen);

                //下面打印信息
                System.out.println("服务器收到来自于端口：" + sourcePort + "的信息：" + message);

                //下面开始发送信息
                out.write("回发响应信息！".getBytes());

                //关闭
                out.close();
                in.close();
                socket.close();
            }
        } catch(Exception e) {
        	System.out.println(e.getMessage());
        } finally {
            if(serverSocket != null) {
                try {
					serverSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
	}
	
	public static void main(String args[]) throws IOException{
		new SocketServer().service();
	}

}
