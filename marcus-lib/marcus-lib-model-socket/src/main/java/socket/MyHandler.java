package socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class MyHandler {
	public static void main(String args[]) {
		MyHandler handle = new MyHandler();
		InetSocketAddress inetSocketAddress = new InetSocketAddress(8000);
		try {
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.socket().bind(inetSocketAddress);
			SocketChannel socketChannel = serverSocketChannel.accept();
			socketChannel.configureBlocking(false);	//设为非阻塞模式，默认为阻塞模式
			Selector selector = Selector.open();	//selector静态工厂方法
			System.out.println(selector.isOpen());
			SelectionKey key = socketChannel.register(selector, SelectionKey.OP_READ|SelectionKey.OP_WRITE);
		} catch (ClosedChannelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
