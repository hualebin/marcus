package thread;

public class RunTwo {
	
	public static void main(String args[]) throws InterruptedException{
		ThreadThree tt = new ThreadThree();
		tt.start();
		Thread.sleep(2000);
		tt.interrupt();
	}

}
