package thread.partThree;

import java.util.concurrent.CountDownLatch;

public class Videoconference implements Runnable {
	private final CountDownLatch controller;
	
	public Videoconference(int number) {
		controller = new CountDownLatch(number);
	}
	
	public void arrive(String name) {
		System.out.println(name + " has arrived");
		
		controller.countDown();	//计数器减去一，当减到0时，被await()方法休眠的线程立刻被唤醒执行，再执行countDown()将不起任何作用
		System.out.println("VideoConfrence: Waiting for " + controller.getCount() + "participants.");
	}

	@Override
	public void run() {
		try {
			System.out.println("VideoConfrence: Initialization " + controller.getCount() + "participants");
			controller.await(); //需要等待其他事件先完成的线程调用
			System.out.println("VideoConfrence: All the participants have come");
			System.out.println("let's start .....");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
