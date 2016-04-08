package thread;

public class Run {
	
	public static void main(String args[]) throws InterruptedException{
		/*ThreadOne to = new ThreadOne();
		System.out.println("begin--" + to.isAlive());
		to.start();
		Thread.sleep(1000);
		System.out.println("end--" + to.isAlive());*/
		System.out.println(Thread.currentThread().getName()+"-"+Thread.currentThread().getId());
	}

}
