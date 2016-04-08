package thread;

public class ThreadDemo extends Thread{
	public void run(){
		System.out.println("MyThread running .......");
	}
	
	public static void main (String args[]) throws InterruptedException{
		ThreadDemo td = new ThreadDemo();
		td.start();
		System.out.println("当前线程名称：" + td.getName());
		td.setName("521");
		System.out.println("当前线程名称：" + td.getName());
	}

}
