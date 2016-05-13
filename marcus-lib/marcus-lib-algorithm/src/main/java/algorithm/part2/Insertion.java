package algorithm.part2;

/**
 * 插入排序实现
 * @author Administrator
 *
 */
public class Insertion extends Example{

	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		for(int i = 1; i < a.length; i++){
			for(int j = i; j > 0 && less(a[j], a[j-1]); j--){
				exch(a, j, j-1);
			}
		}
	}

}
