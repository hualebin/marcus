package thread;

public class ThreadOne extends Thread{
	public void run(){
		System.out.println("run--" + this.isAlive());
	}

}
