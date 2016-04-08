package thread;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*System.out.println(Thread.currentThread().getName());	//打印出的main与main方法没有任何关系，只是名字相同而已
		MyThread myThread = new MyThread();
		Thread a = new Thread(myThread, "A");
		Thread b = new Thread(myThread, "B");
		Thread c = new Thread(myThread, "C");
		Thread d = new Thread(myThread, "D");
		Thread e = new Thread(myThread, "E");
		a.start();
		b.start();
		c.start();
		d.start();
		e.start();*/
		
		
		/*ALogin a = new ALogin();
		a.start();
		BLogin b = new BLogin();
		b.start();*/
		
		/*Demo d = new Demo();
		//d.start();
		d.run();*/
		CountOperate co = new CountOperate();
		co.start();
		
	}

}
