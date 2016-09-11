package thread.partTwo;

import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
	private EventStorage eventStorage;
	
	public Consumer(EventStorage eventStorage) {
		this.eventStorage = eventStorage;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				TimeUnit.MILLISECONDS.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			eventStorage.get();
		}
	}

}
