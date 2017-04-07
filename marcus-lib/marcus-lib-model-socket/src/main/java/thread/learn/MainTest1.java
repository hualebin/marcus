package thread.learn;

public class MainTest1 {
	public static void main(String[] args) {
		Cinema cinema = new Cinema();
		
		TicketOffice1 t1 = new TicketOffice1(cinema);
		Thread thread1 = new Thread(t1);
		
		TicketOffice2 t2 = new TicketOffice2(cinema);
		Thread thread2 = new Thread(t2);
		
		thread1.start();
		thread2.start();
		
		try{
			thread1.join();
			thread2.join();
		} catch (InterruptedException  e) {
			e.printStackTrace();
		}
		
		System.out.println(cinema.getVacanciesCinema1());
		System.out.println(cinema.getVacanciesCinema2());
	}
}
