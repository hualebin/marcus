package thread.partTwo;

public class Main {
	
	public static void main(String[] args) {
		/*EventStorage storage = new EventStorage();
		
		Producer producer = new Producer(storage);
		Thread thread1 = new Thread(producer);
		
		Consumer consumer = new Consumer(storage);
		Thread thread2 = new Thread(consumer);
		
		thread1.start();
		thread2.start();*/
		
		/*PrintQueue printQueue = new PrintQueue();
		Thread thread[] = new Thread[10];
		for (int i = 0; i < 10; i++) {
			thread[i] = new Thread(new Job(printQueue), "Thread" + i);
		}
		
		for (int i = 0; i < 10; i++) {
			thread[i].start();
		}*/
		
		PricesInfo pricesInfo = new PricesInfo();
		
		Reader readers[] = new Reader[5];
		Thread threadsReader[] = new Thread[5];
		for (int i = 0; i < 5; i++) {
			readers[i] = new Reader(pricesInfo);
			threadsReader[i] = new Thread(readers[i]);
		}
		
		Writer writer = new Writer(pricesInfo);
		Thread threadWriter = new Thread(writer);
		
		for (int i = 0; i < 5; i++) {
			threadsReader[i].start();
		}
		
		threadWriter.start();
	}

}
