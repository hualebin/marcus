package thread;

public class Demo extends Thread{
	public Demo(){
		System.out.println("构造方法的打印" + Thread.currentThread().getName());
	}
	
	public void run(){
		System.out.println("run方法的打印" + Thread.currentThread().getName());
	}
	

}
