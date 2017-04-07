package algorithm.part2;

public class Quick {
	
	public void sort(Comparable a[]) {
		sort(a, 0, a.length-1);
	}
	
	public void sort(Comparable a[], int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int k = partition(a, lo, hi);
		sort(a, lo, k-1);
		sort(a, k+1, hi);
	}
	
	public int partition(Comparable a[], int lo, int hi) {
		Comparable v = a[lo];
		int j = hi + 1;
		int i = lo;
		while (true) {
			while (a[++i].compareTo(v) < 0) {
				if (i == hi) {
					break;
				}
			}
			while (a[--j].compareTo(v) > 0) {
				if (j == lo) {
					break;
				}
			}
			if (j <= i) {
				break;
			}
			Comparable temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		a[lo] = a[j];
		a[j] = v;		
		return j;
	}
	
	public static void main(String[] args) {
		
	}

}
