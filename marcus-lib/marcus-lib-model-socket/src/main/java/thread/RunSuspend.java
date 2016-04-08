package thread;

public class RunSuspend {
	
	public static void main(String args[]) throws InterruptedException{
		ThreadSuspend ts = new ThreadSuspend();
		ts.start();
		Thread.sleep(2000);
		ts.suspend();
		System.out.println("A=" + System.currentTimeMillis() + "i=" + ts.getI());
		Thread.sleep(5000);
		System.out.println("A=" + System.currentTimeMillis() + "i=" + ts.getI());
		ts.resume();
		Thread.sleep(5000);
		ts.suspend();
		System.out.println("B=" + System.currentTimeMillis() + "i=" + ts.getI());
		Thread.sleep(5000);
		System.out.println("B=" + System.currentTimeMillis() + "i=" + ts.getI());
	}

}
