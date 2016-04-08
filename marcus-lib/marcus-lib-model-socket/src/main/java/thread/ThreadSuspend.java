package thread;

public class ThreadSuspend extends Thread{
	private long i = 0;

	public long getI() {
		return i;
	}

	public void setI(long i) {
		this.i = i;
	}
	
	public void run() {
		while(true){
			i++;
		}
	}

}
