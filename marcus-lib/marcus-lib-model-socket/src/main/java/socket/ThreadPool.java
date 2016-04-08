package socket;

import java.util.LinkedList;

/**
 * 线程池
 * @author Administrator
 *
 */
public class ThreadPool extends ThreadGroup{
	private boolean isClosed = false;       //线程池是否关闭
	private LinkedList<Runnable> workQueue;   //表示工作队列
	private static int threadPoolID;        //表示线程池id
	private int threadID;     //表示工作线程ID
	
	public ThreadPool(int poolSize){  //poolSize指定线程池中的工作线程的数目
		super("ThreadPool-" + (threadPoolID++));
		setDaemon(true);
		workQueue = new LinkedList<Runnable>(); //创建工作队列
		for(int i = 0; i < poolSize; i++){
			new WorkThread().start();
		}
	}
	
	/**
	 * 向工作队列添加任务，有工作线程执行该任务
	 * @param task
	 */
	public synchronized void execute(Runnable task){
		if(isClosed){			//如果线程池关闭，则抛出IllegalStateException异常
			throw new IllegalStateException();
		}
		if(task != null){
			workQueue.add(task);
			notify();			//唤醒正在getTask()方法中等待任务的工作线程
		}
	}
	
	/**
	 * 从工作队列中取出一个任务， 工作线程会调用此方法
	 * @return
	 * @throws InterruptedException
	 */
	protected synchronized Runnable getTask() throws InterruptedException{
		while(workQueue.size() == 0){
			if(isClosed){
				return null;
			}
			wait();			//如果工作队列中没有任务，就等待任务
		}
		return workQueue.removeFirst();
	}
	
	/**
	 * 关闭线程池
	 */
	public synchronized void close(){
		if(!isClosed){
			isClosed = true;
			workQueue.clear();		//清空工作队列
			interrupt();	//中断所有的工作线程， 该方法继承之ThreadPool的方法											
		}
	}
	
	/**
	 * 等待工作线程把所有的任务执行完
	 */
	public void join(){
		synchronized (this) {
			isClosed = true;
			notifyAll(); 	//唤醒还在getTask()方法中等待任务的工作线程
		}
		Thread[] threads = new Thread[activeCount()];
		int count = enumerate(threads);
		for(int i = 0; i < count; i++){
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 内部类,工作线程
	 * @author Administrator
	 *
	 */
	private class WorkThread extends Thread{
		public WorkThread(){
			super(ThreadPool.this, "WorkThread-" + (threadID++));
		}
		
		public void run(){
			while(!isInterrupted()){ 	//Thread类的一个方法判断线程是否终止
				Runnable task = null;
				try{
					task = getTask();	//取出任务
				}catch (InterruptedException ex){
					System.out.println();
				}
				if(task == null){
					return;
				}
				try{
					task.run();
				}catch (Throwable e){
					e.printStackTrace();
				}
			}
		}
	}

}
