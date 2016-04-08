package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//服务器端
public class Recevier {
	private int port = 8888;
	private ServerSocket serverSocket;
	private static int stopWay = 1; // 结束通信的方式
	private final int NATURAL_STOP = 1; // 自然结束
	private final int SUDDEN_STOP = 2; // 突然终止程序
	private final int SOCKET_STOP = 3; // 关闭Socket，再终止程序
	private final int INPUT_STOP = 4; // 关闭输入流，再终止程序
	private final int SERVERSOCKET_STOP = 5; // 关闭ServerSocket,再终止程序

	public Recevier() throws IOException {
		serverSocket = new ServerSocket(port);
		System.out.println("服务器启动成功............");
	}

	public BufferedReader getReader(Socket socket) throws IOException {
		InputStream is = socket.getInputStream();
		return new BufferedReader(new InputStreamReader(is));
	}

	public void recevie() {
		Socket socket = null;
		try {
			socket = serverSocket.accept();
			BufferedReader br = getReader(socket);
			for (int i = 0; i < 20; i++) {
				String msg = br.readLine();
				System.out.println("接收第" + i + "条信息:" + msg);
				Thread.sleep(1000);
				if (i == 2) { // 终止程序结束通信
					if (stopWay == SUDDEN_STOP) {
						System.out.println("突然终止程序");
						System.exit(0);
					} else if (stopWay == SOCKET_STOP) {
						System.out.println("关闭Socket，终止程序");
						socket.close();
						break;
					} else if (stopWay == INPUT_STOP) {
						System.out.println("关闭输入流，终止程序");
						socket.shutdownInput();
						break;
					} else if (stopWay == SERVERSOCKET_STOP) {
						System.out.println("关闭ServerSocket，终止程序");
						serverSocket.close();
						break;
					}
				}
			}
			if (stopWay == NATURAL_STOP) {
				socket.close();
				serverSocket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String args[]) throws IOException,
			InterruptedException {
		new Recevier().recevie();
	}

}
