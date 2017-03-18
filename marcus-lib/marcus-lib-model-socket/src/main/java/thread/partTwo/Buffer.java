package thread.partTwo;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class Buffer {
	private LinkedList<String> buffer;
	private int maxSize;
	private ReentrantLock lock;
	private Condition lines;
	private Condition space;
	private boolean pendingLines;
	
	public Buffer(int maxSize) {
		this.maxSize = maxSize;
		buffer = new LinkedList<String>();
		lock = new ReentrantLock();
		lines = lock.newCondition();
		space = lock.newCondition();
		pendingLines = true;
	}
	
	public void insert(String line) {
		lock.lock();
		try {
			while (buffer.size() == maxSize) {
				space.await();
			}
			buffer.offer(line);
			System.out.println(Thread.currentThread().getName() + "Inserted Line:" + buffer.size());
			lines.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
