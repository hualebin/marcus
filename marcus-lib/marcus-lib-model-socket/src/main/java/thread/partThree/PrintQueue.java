package thread.partThree;

import java.util.concurrent.Semaphore;

/**
 * semaphore 信号量
 * @author Administrator
 *
 */
public class PrintQueue {
	
	private final Semaphore semaphore;
	
	public PrintQueue() {
		semaphore = new Semaphore(1);
	}
	
	public void printJob(Object document) {
		try {
			semaphore.acquire();	//获取信号量
			long duration = (long) (Math.random()*10);
			System.out.println(Thread.currentThread().getName() + "PrintQueue: Printing a Job during "+ duration + "seconds");
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
