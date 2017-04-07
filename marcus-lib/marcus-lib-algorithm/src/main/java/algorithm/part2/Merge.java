package algorithm.part2;

public class Merge {
	private static Comparable aux[];
	
	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}
	
	public static void sort(Comparable[] a, int lo, int hi){
		if (hi <= lo) {
			return;
		}
		int mid = (lo + hi) / 2;
		sort(a, lo, mid);
		sort(a, mid + 1, hi);
		merage(a, lo, mid, hi);
	}
	
	public static void merage(Comparable[] a, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;
		for (int k = i; k <= hi; k++) {
			aux[k] = a[k];
		}
		
		for (int k = i; k <= hi; k++) {
			if (i > mid) {
				a[k] = aux[j++];
			} else if (j > hi) {
				a[k] = aux[i++];
			} else if (a[i].compareTo(a[j]) > 0) {
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}
		}		
		
	}
	
	public static void main(String[] args) {
		int lo = 3;
		int hi = 8;
		System.out.println((lo + hi) / 2);
		System.out.println(lo + (hi -lo) / 2);
	}

}
