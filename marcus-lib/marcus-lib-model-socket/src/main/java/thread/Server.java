package thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {
	
	private ThreadPoolExecutor executor;
	
	public Server() {
		executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
	}
	
	public void executeTask(Task task) {
		System.out.printf("Server: A new task hash arrived\n");
		executor.execute(task);
		System.out.printf("Server: Pool Size: %d\n", executor.getPoolSize());
	}
	
	public void endServer() {
		executor.shutdown();
	}

}
