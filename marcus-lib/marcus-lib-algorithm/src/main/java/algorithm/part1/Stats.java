package algorithm.part1;

/**
 * 背包典型用例
 * @author Administrator
 *
 */
public class Stats {
	public static void main(String[] args) {
		edu.princeton.cs.algs4.Bag<Double> numbers = new edu.princeton.cs.algs4.Bag<Double>();
		numbers.add(90.0);
		numbers.add(56.23);
		numbers.add(89.10);
		numbers.add(100.01);
		int N = numbers.size();
		double sum = 0.0;
		for(double d : numbers){
			sum += d;
		}
		double mean = sum/N;
		sum = 0.0;
		for(double x : numbers){
			sum += (x - mean)*(x - mean);
		}
		double std = Math.sqrt(sum/(N-1));
		System.out.println("Mean:" + mean);
		System.out.println("std dev:" + std);
	}

}
