package thread;

import java.util.concurrent.TimeUnit;

import thread.partOne.Calculator;
import thread.partOne.PrimeGenerator;

public class Main {
	
	public static void main(String[] args) {
		/*for (int i = 0; i < 10; i++) {
			Calculator calculator = new Calculator(i);
			new Thread(calculator).start();
		}*/
		Thread thread = new Calculator(1);
		//thread.setDaemon(true);
		thread.start();
		thread.interrupt();
		
		Thread task = new PrimeGenerator();
		
		task.start();
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		task.interrupt();
	}

}
