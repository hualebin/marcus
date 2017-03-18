package thread.partThree;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 信号量Semaphore的使用, 使用acquire()获取信号量, 使用release()释放信号量
 * 其他两种acquire()方法
 * acquireUninterruptibly()就是acquire()方法，线程阻塞可能造成线程中断，acquire()方法抛出InterruptedException,
 * acquireUninterruptibly()不会抛出异常
 * tryAcquire()方法，如果能获得则返回true,如果不能,则返回false
 * @author marcus
 *	信号量的公平性默认是非公平模式，公平模式会选择等待时间最长的线程
 *	跟lock锁一样
 */
public class PrintQueue {
	private final Semaphore semaphore;
	
	private boolean freePrinters[];
	
	private Lock lockPrinters;
	
	public PrintQueue() {
		semaphore =  new Semaphore(3);
		freePrinters = new boolean[3];
		for (int i = 0; i < 3; i++) {
			freePrinters[i] = true;
		}
		lockPrinters = new ReentrantLock();
	}
	
	public void printJob (Object document) {
		try {
			semaphore.acquire(); //获取信号量
			int assignedPrinter = getPrinter();
			long duration = (long) (Math.random()*10);
			System.out.println(Thread.currentThread().getName() + " Printing a Job during " + duration + "seconds");
			TimeUnit.SECONDS.sleep(duration);
			freePrinters[assignedPrinter] = true;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release(); //释放信号量
		}
	}
	
	private int getPrinter() {
		int ret = -1;
		try {
			lockPrinters.lock();
			
			for (int i = 0; i < freePrinters.length; i++) {
				if (freePrinters[i]) {
					ret = i;
					freePrinters[i] = false;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lockPrinters.unlock();
		}
		return ret;
	}

}
