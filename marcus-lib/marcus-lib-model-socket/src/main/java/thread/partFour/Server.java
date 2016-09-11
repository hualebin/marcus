package thread.partFour;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {
	
	private ThreadPoolExecutor executor;
	
	public Server() {
		//executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
		//executor = (ThreadPoolExecutor) Executors.newSingleThreadExecutor();
	}
	
	public void executeTask(Task task) {
		System.out.println("Server: A new task has arrived");
		executor.execute(task);
		System.out.printf("Server: Task Count: %d\n", executor.getTaskCount());
		System.out.printf("Server: Pool Size: %d\n", executor.getPoolSize()); //返回执行器线程池中的实际的线程数
		System.out.printf("Server: Active Count: %d\n", executor.getActiveCount());	//返回执行器中正在执行任务的线程数
		System.out.printf("Server: Completed Tasks: %d\n", executor.getCompletedTaskCount());	//返回执行器已经完成的任务数
	}
	
	public void endServer() {
		executor.shutdown();
	}

}
