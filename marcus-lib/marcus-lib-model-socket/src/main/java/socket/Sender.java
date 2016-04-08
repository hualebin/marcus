package socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Sender {
	private String host = "localhost";
	private int port = 8888;
	private Socket socket;
	private static int stopWay = 1;
	private final int NATURAL_STOP = 1; // 自然结束
	private final int SUDDEN_STOP = 2; // 突然终止程序
	private final int SOCKET_STOP = 3; // 关闭Socket，再终止程序
	private final int OUTPUT_STOP = 4; // 关闭输出流，再终止程序

	public Sender() throws IOException {
		socket = new Socket(host, port);
	}

	public PrintWriter getWriter(Socket socket) throws IOException {
		OutputStream os = socket.getOutputStream();
		return new PrintWriter(os, true);
	}

	public void send() {
		try {
			PrintWriter pw = getWriter(socket);
			for (int i = 0; i < 20; i++) {
				String msg = "hello_" + i;
				pw.println(msg);
				System.out.println("发送第" + i + "条信息：" + msg);
				Thread.sleep(500);
				if (i == 2) {
					if (stopWay == SUDDEN_STOP) {
						System.out.println("突然终止程序");
						System.exit(0);
					} else if (stopWay == SOCKET_STOP) {
						System.out.println("关闭Socket，终止程序");
						socket.close();
						break;
					} else if (stopWay == OUTPUT_STOP) {
						System.out.println("关闭输出流，终止程序");
						socket.shutdownOutput();
						break;
					}
				}
			}
			if (stopWay == NATURAL_STOP) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

	}

	public static void main(String args[]) throws IOException,
			InterruptedException {
		new Sender().send();
	}

}
