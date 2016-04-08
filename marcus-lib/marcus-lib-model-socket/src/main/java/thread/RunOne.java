package thread;

public class RunOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ThreadTwo tt = new ThreadTwo();
			tt.start();
			Thread.sleep(2000);
			tt.interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
