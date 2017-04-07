package thread.learn;

/**
 * 一个对象的方法采用synchronized关键字进行声明，只能被一个线程访问，如果线程A正在执行一个同步方法synMethodA()
 * ,线程B要执行这个对象的其他同步方法syncMethodB(),线程B将被阻塞直到线程A访问完，但如果线程B访问的不是同一个类的不同对象
 * ，那么两个线程都不会被阻塞
 * @author marcus
 *
 */
public class MainTest {
	public static void main(String[] args) {
		Account account = new Account();
		account.setBalance(1000);
		
		Company company = new Company(account);
		
		Thread companyThread = new Thread(company);
		
		Bank bank = new Bank(account);
		
		Thread bankThread = new Thread(bank);
		
		System.out.println("Account : Inital Banlance: " + account.getBalance());
		companyThread.start();
		bankThread.start();
		
		try {
			companyThread.join();
			bankThread.join();
			System.out.println("Account : Final Balance: " + account.getBalance());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
