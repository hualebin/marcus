package socket;

import java.util.concurrent.CountDownLatch;

public class SocketClientDemo {
	public static int clientNumber = 20;
	public CountDownLatch countDownLatch;	//java同步计数器
	
	public SocketClientDemo(){
		countDownLatch = new CountDownLatch(clientNumber);
	}
	
	public static void main(String args[]) throws Exception {
		SocketClientDemo scd = new SocketClientDemo();
		//分别开始启动20个客户端
		for(int i = 0; i < clientNumber; i++ ,scd.countDownLatch.countDown()){
			SocketClientRequestThread  scrt = new SocketClientRequestThread(scd.countDownLatch, i);
			new Thread(scrt).start();
		}
		
		//这个wait不涉及到具体的实验逻辑，只是为了保证守护线程在启动所有线程后，进入等待状态
        synchronized (SocketClientDemo.class) {
        	SocketClientDemo.class.wait();
        }
	}

}
