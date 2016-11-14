package thread.partFour;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskTest implements Callable<String> {
	
	private String name;
	
	public TaskTest(String name) {
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		System.out.println(this.name + ": Starting at : " + new Date());
		return "Hello, World";
	}
	
	public static void main(String[] args) {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		
		System.out.println("Main: Starting at: " + new Date());
		for (int i = 0; i < 5; i++) {
			TaskTest task = new TaskTest("Task" + i);
			executor.schedule(task, i + 1, TimeUnit.SECONDS);
		}
		executor.shutdown();
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Main: Ends at: " + new Date());
	}

}
