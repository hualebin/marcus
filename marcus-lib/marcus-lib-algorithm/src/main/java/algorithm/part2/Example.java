package algorithm.part2;
import edu.princeton.cs.algs4.*;

/**
 * 排序抽象模板
 * @author Administrator
 *
 */
public abstract class Example {
	
	public abstract void sort(Comparable[] a);
	
	//对元素进行比较
	protected boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
	
	//元素位置交换
	protected void exch(Comparable[] a, int i, int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	//打印数组内容
	protected void show(Comparable[] a){
		for(int i = 0; i < a.length; i++){
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}

}
