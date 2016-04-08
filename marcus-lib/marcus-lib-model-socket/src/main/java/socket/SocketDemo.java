package socket;

import java.io.IOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/*Socket用来连接服务器最简单的方法就是使用IP地址和端口号，但是Socket类中的connect方法没有提供这种方式
 connect方法是用SocketAddress对象作为参数，SocketAddress是IP地址加端口号
 SocketAddress只是个抽象类，它除了有一个默认的构造方法外，其它的方法都是abstract的
 因此，我们必须使用SocketAddress的子类来建立SocketAddress对象，也就是唯一的子类InetSocketAddress
 */
public class SocketDemo {
	private Socket socket;

	public SocketDemo() {
		socket = new Socket();
	}

	public void linkServer(String host, int port) {
		SocketAddress socketAddress = new InetSocketAddress(host, port);
		try {
			socket.connect(socketAddress, 60000);// 连接服务器，超时时间为1分钟
			System.out.println("连接服务器成功.....");
		} catch (SocketTimeoutException e) {
			// TODO Auto-generated catch block
			System.out.println("连接服务器超时.....");
		} catch (IOException e1) {
			System.out.println("连接服务器失败.....");
		} finally {
			if (socket != null) {
				try {
					socket.close();
					System.out.println("连接服务器关闭.....");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void test(String host, int port) {
		SocketAddress socketAddress = new InetSocketAddress(host, port);
		String result = "";
		try {
			long begin = System.currentTimeMillis();// 获取当前系统时间的毫秒数
			socket.connect(socketAddress, 1000);// 连接服务器，超时时间为1秒钟
			long end = System.currentTimeMillis();
			result = (end - begin) + "ms";// 计算连接时间
		} catch (BindException e) {
			result = "local adress and port can not be binded";
		} catch (UnknownHostException e1) {
			result = "Unknown Host";
		} catch (ConnectException e2) {
			result = "Connection refused";
		} catch (SocketTimeoutException e3) {
			result = "TimeOut";
		} catch (IOException e4) {
			result = "failure";
		} finally {
			try {
				if (socket != null) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(socketAddress + ":" + result);
	}

	public static void main(String args[]) {
		String host = "localhost";
		int port = 8000;
		if(args.length>0){
			host = args[0];
			port = Integer.parseInt(args[1]);
		}
		new SocketDemo().test(host, port);
	}
}
