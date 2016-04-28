package algorithm.part1;

public class TestQueue {
	
	public static void test(){
		edu.princeton.cs.algs4.Queue<Integer> q = new edu.princeton.cs.algs4.Queue<Integer>();
		q.enqueue(10);
		q.enqueue(2);
		q.enqueue(29);
		q.enqueue(52);
		int N = q.size();
		for(int i = 0; i< N; i++){
			System.out.println("出队列" + q.dequeue());
		}
	}
	
	public static void main(String[] args) {
		test();
	}

}
