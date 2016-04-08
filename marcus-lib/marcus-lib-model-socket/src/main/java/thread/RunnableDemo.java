package thread;

public class RunnableDemo implements Runnable{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("MyRunnable running.....");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunnableDemo rd = new RunnableDemo();
		Thread td = new Thread(rd); //	Thread的run方法调用RunnableDemo的run方法
		td.start();
	}

}
