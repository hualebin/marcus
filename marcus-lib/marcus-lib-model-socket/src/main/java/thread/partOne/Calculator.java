package thread.partOne;

public class Calculator extends Thread {
	
	private int number;
	
	public Calculator(int number) {
		this.number = number;
	}

	@Override
	public void run() {
		System.out.println("线程" + number + "运行了");
		if (isInterrupted()) {
			System.out.println("线程" + number + "中断了");
		}
	}

}
