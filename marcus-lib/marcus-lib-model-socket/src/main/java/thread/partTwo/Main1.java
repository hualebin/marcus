package thread.partTwo;

public class Main1 {
	public static void main(String[] args) {
		EventStorage storage = new EventStorage();
		
		Producer producer = new Producer(storage);
		Thread thread1 = new Thread(producer);
		
		Consumer concumer = new Consumer(storage);
		Thread thread2 = new Thread(concumer);
		
		thread1.start();
		thread2.start();
	}
}
