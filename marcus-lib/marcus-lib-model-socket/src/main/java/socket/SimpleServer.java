package socket;

import java.net.ServerSocket;

public class SimpleServer {
	public static void main(String args[]) throws Exception{
		ServerSocket serverSocket = new ServerSocket(8000,2);
		Thread.sleep(360000);
	}

}
