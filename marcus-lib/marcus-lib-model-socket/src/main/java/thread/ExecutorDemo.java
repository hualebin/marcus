package thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		System.out.println("程序开始运行........");
		Date date1 = new Date();
		
		int taskSize = 5;
		//创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);
		//创建多个返回值的任务
		List<Future> list = new ArrayList<Future>();
		for(int i = 0; i < taskSize; i++){
			Callable c = new MyCallable(i + "");
			Future f = pool.submit(c);
			list.add(f);
		}
		pool.shutdown();
		
		for(Future f : list){
			System.out.println(">>>" + f.get().toString());
		}
		
		Date date2 = new Date();
		long time = date2.getTime() - date1.getTime();
		System.out.println("-----程序结束运行-----，程序运行时间{" + time +"毫秒}");

	}

}

class MyCallable implements Callable<Object>{
	private String taskNum;
	
	MyCallable(String taskNum){
		this.taskNum = taskNum;
	}

	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(">>>" + taskNum + "任务启动");
		Date dateImpl1 = new Date();
		Thread.sleep(1000);
		Date dateImpl2 = new Date();
		long time = dateImpl2.getTime() - dateImpl1.getTime();
		System.out.println(">>>" + taskNum + "任务终止");
		return taskNum + "任务返回运行结果，当前任务时间{" + time +"毫秒}";
	}
	
}
