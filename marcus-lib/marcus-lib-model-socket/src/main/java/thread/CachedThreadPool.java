package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			exec.execute(new MyThread());
		}
		exec.shutdown();
		System.out.println("------------------------------");
		
		for (int i = 0; i < 5; i++) {
			new MyThread().start();
		}
	}

}
