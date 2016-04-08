package channel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {
	private int port = 8000;
	private ServerSocketChannel serverSocketChannel = null;
	/*private ExecutorService excutorService;			//线程池
	private static final int POOL_MULTIPLE = 4;		//线程池工作线程数目
*/	private Selector selector = null;
	private Charset charset = Charset.forName("GBK");
	
	public EchoServer() throws IOException{
		selector = Selector.open();
		//创建一个线程池
		//excutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*POOL_MULTIPLE);	//Runtime.getRuntime().availableProcessors()java虚拟机可用处理器个数
		//创建一个SerevrSocketChannel对象
		serverSocketChannel = ServerSocketChannel.open();
		//使得在同一个主机上关闭了服务器程序，紧接着再启动服务程序时，可以顺利绑定到相同的端口
		serverSocketChannel.socket().setReuseAddress(true);
		//设置为非阻塞模式
		serverSocketChannel.configureBlocking(false);
		//将服务器进程绑定到本地的8000的端口
		serverSocketChannel.socket().bind(new InetSocketAddress(port));
		System.out.println("服务器启动了..........");
	}
	
	public void service() throws IOException{
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		while(selector.select() > 0){
			Set<SelectionKey> readKeys = selector.selectedKeys();
			Iterator<SelectionKey> it = readKeys.iterator();
			while(it.hasNext()){
				SelectionKey key = null;
				try{
					key = it.next();
					it.remove();
					if(key.isAcceptable()){
						ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
						SocketChannel sc = ssc.accept();
						System.out.println("接收来自客户端的连接：" + sc.socket().getInetAddress() + ":" + sc.socket().getPort());
						sc.configureBlocking(false);
						ByteBuffer buffer = ByteBuffer.allocate(1024);
						sc.register(selector, SelectionKey.OP_READ|SelectionKey.OP_WRITE, buffer);
					}
					if(key.isReadable()){
						
					}
					if(key.isWritable()){
						send(key);
					}
				}catch (IOException e){
					e.printStackTrace();
				}
			}
			
		}
		/*while(true){
			SocketChannel socketChannel = null;
			try {
				socketChannel = serverSocketChannel.accept();
				excutorService.execute(new Handler(socketChannel));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
	}
	
	public void send(SelectionKey key) throws IOException{
		ByteBuffer buffer = (ByteBuffer) key.attachment();
		SocketChannel sc = (SocketChannel) key.channel();
		buffer.flip();	//	把极限设为位置， 位置设为0
		String data = decode(buffer);
		if(data.indexOf("\r\n") == -1){
			return;
		}
		String outputData = data.substring(0, data.indexOf("\n") + 1);
		System.out.println(outputData);
		ByteBuffer outputBuffer = encode("echo:" + outputData);
		
	}
	
	public void receive(SelectionKey key) throws IOException{
		//ByteBuffer buffer = 
	}
	
	public String decode(ByteBuffer buffer){	//解码
		CharBuffer charBuffer = charset.decode(buffer);
		return charBuffer.toString();
	}
	
	public ByteBuffer encode(String str){	//编码
		return charset.encode(str);
	}

}

/*class Handler implements Runnable{	//处理客户连接
	private SocketChannel socketChannel;
	public Handler(SocketChannel socketChannel){
		this.socketChannel = socketChannel;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		handle();
	}
	
	private void handle(){
		try{
			Socket socket = socketChannel.socket();
			System.out.println("New Connection accepted:"+socket.getInetAddress()+":"+socket.getPort());
			BufferedReader br = getReader(socket);
			PrintWriter pw = getWriter(socket);
			
			String msg = null;
			while((msg=br.readLine())!=null){
				System.out.println(Echo(msg));
				pw.println(Echo(msg));
				if(msg.equals("bye")){
					break;
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(socketChannel!=null){
					socketChannel.close();
				}
			}catch(IOException e1){
				e1.printStackTrace();
			}
		}
	}
	
	private PrintWriter getWriter(Socket socket) throws IOException {
		OutputStream os = socket.getOutputStream();
		return new PrintWriter(os, true);
	}

	private BufferedReader getReader(Socket socket) throws IOException {
		InputStream is = socket.getInputStream();
		return new BufferedReader(new InputStreamReader(is));
	}
	
	private String Echo(String msg){
		return "echo:"+msg;
	}
}
*/