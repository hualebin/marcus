package channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;


public class SocketServer {
	private int port = 8000;
	private ServerSocketChannel serverSocketChannel = null;
	private Selector selector = null;
	
	public SocketServer() throws IOException{
		serverSocketChannel = ServerSocketChannel.open();
		selector = Selector.open();
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
		try{
			while(true){
				//如果条件成立，说明本次询问selector，并没有获取到任何准备好的、感兴趣的事件
                //java程序对多路复用IO的支持也包括了阻塞模式 和非阻塞模式两种。
                if(selector.select(100) == 0) {
                    //================================================
                    //      这里视业务情况，可以做一些然并卵的事情
                    //================================================
                    continue;
                }
                Set<SelectionKey> readKeys = selector.selectedKeys();
    			Iterator<SelectionKey> it = readKeys.iterator();
    			while(it.hasNext()){
    				SelectionKey key = it.next();
    				//这个已经处理的readyKey一定要移除。如果不移除，就会一直存在在selector.selectedKeys集合中
                    //待到下一次selector.select() > 0时，这个readyKey又会被处理一次
    				it.remove();
    				if(key.isValid()){
	    				SelectableChannel selectableChannel = key.channel();
	    				if(key.isAcceptable()){
	    					ServerSocketChannel serverChannel = (ServerSocketChannel) selectableChannel;
	    					SocketChannel socketChannel = serverChannel.accept();
	    					System.out.println("接收来自客户端的连接：" + socketChannel.socket().getInetAddress() + ":" + socketChannel.socket().getPort());
	    					socketChannel.configureBlocking(false);
							ByteBuffer buffer = ByteBuffer.allocate(1024);
							socketChannel.register(selector, SelectionKey.OP_READ, buffer);
	    				}
	    				if(key.isConnectable()) {
	                        System.out.println("======socket channel 建立连接=======");
	    				}
	    				if(key.isReadable()){
	    					readSocketChannel(key);
	    				}
    				}
    			}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(serverSocketChannel != null){
				serverSocketChannel.close();
			}
		}
	}
	
	 /**
     * 这个方法用于读取从客户端传来的信息。
     * 并且观察从客户端过来的socket channel在经过多次传输后，是否完成传输。
     * 如果传输完成，则返回一个true的标记。
     * @param socketChannel
     * @throws Exception
     */
    private static void readSocketChannel(SelectionKey readyKey) throws Exception {
        SocketChannel clientSocketChannel = (SocketChannel)readyKey.channel();
        //获取客户端使用的端口
        InetSocketAddress sourceSocketAddress = (InetSocketAddress)clientSocketChannel.getRemoteAddress();
        Integer resoucePort = sourceSocketAddress.getPort();

        //拿到这个socket channel使用的缓存区，准备读取数据
        //在后文，将详细讲解缓存区的用法概念，实际上重要的就是三个元素capacity,position和limit。
        ByteBuffer contextBytes = (ByteBuffer)readyKey.attachment();
        //将通道的数据写入到缓存区，注意是写入到缓存区。
        //由于之前设置了ByteBuffer的大小为2048 byte，所以可以存在写入不完的情况
        //没关系，我们后面来调整代码。这里我们暂时理解为一次接受可以完成
        int realLen = -1;
        try {
            realLen = clientSocketChannel.read(contextBytes);
        } catch(Exception e) {
            //这里抛出了异常，一般就是客户端因为某种原因终止了。所以关闭channel就行了
            System.out.println(e.getMessage());
            clientSocketChannel.close();
            return;
        }

        //如果缓存区中没有任何数据（但实际上这个不太可能，否则就不会触发OP_READ事件了）
        if(realLen == -1) {
        	System.out.println("====缓存区没有数据？====");
            return;
        }

        //将缓存区从写状态切换为读状态（实际上这个方法是读写模式互切换）。
        //这是java nio框架中的这个socket channel的写请求将全部等待。
        contextBytes.flip();
        //注意中文乱码的问题，我个人喜好是使用URLDecoder/URLEncoder，进行解编码。
        //当然java nio框架本身也提供编解码方式，看个人咯
        byte[] messageBytes = contextBytes.array();
        String messageEncode = new String(messageBytes , "UTF-8");
        String message = URLDecoder.decode(messageEncode, "UTF-8");

        //如果收到了“over”关键字，才会清空buffer，并回发数据；
        //否则不清空缓存，还要还原buffer的“写状态”
        if(message.indexOf("over") != -1) {
            //清空已经读取的缓存，并从新切换为写状态(这里要注意clear()和capacity()两个方法的区别)
            contextBytes.clear();
            System.out.println("端口:" + resoucePort + "客户端发来的信息======message : " + message);

            //======================================================
            //          当然接受完成后，可以在这里正式处理业务了        
            //======================================================

            //回发数据，并关闭channel
            ByteBuffer sendBuffer = ByteBuffer.wrap(URLEncoder.encode("回发处理结果", "UTF-8").getBytes());
            clientSocketChannel.write(sendBuffer);
            clientSocketChannel.close();
        } else {
        	System.out.println("端口:" + resoucePort + "客户端信息还未接受完，继续接受======message : " + message);
            //这是，limit和capacity的值一致，position的位置是realLen的位置
            contextBytes.position(realLen);
            contextBytes.limit(contextBytes.capacity());
        }
    } 
    
    public static void main(String args[]) throws IOException{
    	new SocketServer().service();
    }

}
