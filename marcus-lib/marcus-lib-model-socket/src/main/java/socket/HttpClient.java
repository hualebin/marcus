package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class HttpClient {
	private String host = "www.javathinker.org";
	private int port = 80;
	private Socket socket;

	public HttpClient() throws IOException {
		socket = new Socket(host, port);
		System.out.println(socket.isClosed());
		System.out.println(socket.isBound());
		System.out.println(socket.isConnected());
	}

	public void communicate() throws IOException {
		StringBuffer sb = new StringBuffer("GET" + "/index.jsp" + "HTTP/1.1\r\n");
		sb.append("Host:www.javathinker.org\r\n");
		sb.append("Accept:*/*\r\n");
		sb.append("Accept-Language:zh-cn\r\n");
		sb.append("Accept-Encoding:gzip,deflate\r\n");
		sb.append("User-Agent:Mozilla/4.0(compatible;MSIE 6.0;Windows NT 5.0)\r\n");
		sb.append("Connection:Keep-Alive\r\n\r\n");

		// 发出HTTP请求
		OutputStream os = socket.getOutputStream();
		os.write(sb.toString().getBytes());
		socket.shutdownOutput(); // 关闭输出流 ，Socket处于半关闭状态

		// 接收响应结果
		InputStream is = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String buffer = null;
		while ((buffer = br.readLine()) != null) {
			System.out.println(buffer);
		}
		socket.close(); // 关闭连接,建议在finally处进行
		System.out.println(socket.isClosed());
		System.out.println(socket.isBound());  //判断Socket是否与本地的一个端口进行绑定
		System.out.println(socket.isConnected()); //曾经连接到主机返回true
	}

	public static void main(String args[]) throws IOException {
		new HttpClient().communicate();
	}
}
