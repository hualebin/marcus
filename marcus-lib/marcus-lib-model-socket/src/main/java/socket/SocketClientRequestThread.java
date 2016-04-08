package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.CountDownLatch;

/**
 * 一个模拟客户端请求的线程
 * @author Administrator
 *
 */
public class SocketClientRequestThread implements Runnable{
	/**
     * countDownLatch是java提供的同步计数器。
     * 当计数器数值减为0时，所有受其影响而等待的线程将会被激活。这样保证模拟并发请求的真实性
     * @param countDownLatch
     */
	private CountDownLatch countDownLatch;
	
	//线程的编号
	private Integer clientIndex;
	
	private static String host = "localhost";
	private static int port = 8000;
	
	public SocketClientRequestThread(CountDownLatch countDownLatch, Integer clientIndex) throws UnknownHostException, IOException{
		this.countDownLatch = countDownLatch;
		this.clientIndex = clientIndex;
	}
	
	private BufferedReader getReader(Socket socket) throws IOException{
		InputStream is = socket.getInputStream();
		return new BufferedReader(new InputStreamReader(is));
	}
	
	private PrintWriter getWriter(Socket socket) throws IOException{
		OutputStream os = socket.getOutputStream();
		return new PrintWriter(os, true);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Socket socket = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			socket = new Socket(host, port);
			br = getReader(socket);
			pw = getWriter(socket);
			
			//等待, 直到所有的线程启动完，然后所有线程一起发送线程
			this.countDownLatch.await();
			//发送请求消息
			pw.println("这是第" + this.clientIndex + "客户端的请求");
			//在这里等待，直到服务器返回消息
			System.out.println("第" + this.clientIndex + "个客户端的请求发送完成，等待服务器返回信息");
			String msg = null;
			while((msg = br.readLine()) != null){
				System.out.println("来自服务器接收到的消息" + msg);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try{
				if(br != null){
					br.close();
				}
				if(pw != null){
					pw.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
			
	}

}
