package algorithm.part2;

/**
 * 希尔排序
 * @author Administrator
 *
 */
public class Shell extends Example{

	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		int N = a.length;
		int h = 1;
		while(h < (N/3)){
			h = 3*h + 1;
		}
		while(h >= 1){
			for(int i = h; i < N; i++){
				for(int j = i; j >= h && less(a[j], a[j-h]); j -= h){
					exch(a, j, j-h);
				}
			}
			h = h/3;
		}
	}

}
