package thread;

public class RunTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 5; i++){
			MyThread1 m1 = new MyThread1();
			m1.setPriority(9);
			m1.start();
			MyThread2 m2 = new MyThread2();
			m2.setPriority(10);
			m2.start();
		}
		
	}

}
