package thread.partFour;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class NewTask implements Callable<Result> {
	private String name;
	
	public NewTask(String name) {
		this.name = name;
	}
	
	@Override
	public Result call() throws Exception {
		try {
			long duration = (long) (Math.random()*10);
			System.out.println(this.name + ":Waiting " + duration + "seconds for results");
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int value = 0;
		for (int i = 0; i < 5; i++) {
			value += (int) (Math.random()*100);
		}
		
		Result result = new Result();
		result.setName(this.name);
		result.setValue(value);
		return result;
	}
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		
		List<NewTask> taskList = new ArrayList<>();
		
		for (int i = 0; i < 3; i++) {
			NewTask task = new NewTask(i + "");
			taskList.add(task);
		}
		
		List<Future<Result>> resultList = null;
		try {
			resultList = executor.invokeAll(taskList);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		executor.shutdown();
		
		for (int i = 0; i < resultList.size(); i++) {
			Future<Result> future = resultList.get(i);
			
			try {
				Result result =  future.get();
				System.out.println(result.getName()+ ": " + result.getValue());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
	
}
