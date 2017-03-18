package thread.learn;
/**
 * 创建线程的方式之一实现Runnable接口
 * @author marcus
 *
 */
public class Calculator implements Runnable {
	private int number;
	public Calculator(int number) {
		this.number = number;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%s: %d * %d = %d\n", Thread.currentThread().getName(), number, i, i*number);
		}
		
	}
	
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			Calculator cal = new Calculator(i);
			Thread thread = new Thread(cal);
			thread.start();//执行run方法
		}
	}

}
/**
 * 线程创建的方式之一继承Thread类
 * @author marcus
 *
 */
class CalculatorAnother extends Thread{
	private int number;
	
	public CalculatorAnother(int number){
		this.number = number;
	}
	//重写run方法
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%s: %d * %d = %d\n", Thread.currentThread().getName(), number, i, i*number);
		}
	}
}
