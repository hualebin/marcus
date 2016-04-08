package thread;

public class ThreadThree extends Thread{
	
	public void run(){
		while(true){
			if(this.interrupted()){
				System.out.println("停止了");
				return;
			}
			System.out.println("timer=" + System.currentTimeMillis());
		}
	}

}
