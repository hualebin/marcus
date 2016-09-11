package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TaskWithResult implements Callable<String> {
	
	private int id;
	
	public TaskWithResult(int id) {
		this.id = id;
	}

	@Override
	public String call() throws Exception {
		return "result of TaskWithResult " + id; 
	} 
	
	 public static Double multiply(Double a, Double b) {
	        return a * b;
	 }
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		List<Future<String>> results = new ArrayList<Future<String>>();
		for (int i = 0; i < 5; i++) {
			Future<String> f = executorService.submit(new TaskWithResult(i));
			results.add(f);
		}
		
		for (Future<String> fs : results) {
			try {
				if (fs.isDone()) {
					System.out.println(fs.get());
				}
			} catch (InterruptedException e) {
				System.out.println(e);
				return;
			} catch (ExecutionException e) {
				System.out.println(e);
			} finally {
				executorService.shutdown();
			}
		}
		
		double a = 2.2;
		double b = 3.2;
		System.out.println(multiply(a, b));
		
		System.out.println(String.format("Hi %s, my name is %s", "marcus", "li"));
	}

}
