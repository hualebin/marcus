package thread.partOne;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class MyThreadFactory implements ThreadFactory {
	private int counter;
	private String name;
	private List<String> stats;
	
	public MyThreadFactory(String name) {
		this.counter = 0;
		this.name = name;
		stats = new ArrayList<String>();
	}

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r, name + "-thread_" + counter);
		counter++;
		stats.add(String.format("Created thread %d with name %s on %s\n", t.getId(), t.getName(), new Date()));
		return t;
	}
	
	public String getStats() {
		StringBuffer sb = new StringBuffer();
		Iterator<String> it = stats.iterator();
		while (it.hasNext()) {
			sb.append(it.next());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
		Task task = new Task();
		
		Thread thread;
		System.out.println("Starting the Threads\n");
		
		for (int i = 0; i < 10; i++) {
			thread = factory.newThread(task);
			thread.start();
		}
		System.out.println("Factory stats: ");
		System.out.println(factory.stats);
	}

}

class Task implements Runnable {

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
