package algorithm.part2;

public class Merge extends Example{
	
	private Comparable[] aux;

	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		aux = new Comparable[a.length];
		sort(a, 0, a.length-1);
	}
	
	private void sort(Comparable[] a, int lo, int hi){
		if(hi <= lo){
			return;
		}
		int mid = lo + (hi - lo)/2;
		sort(a, lo, mid);
		sort(a, mid+1, hi);
		merge(a, lo, mid, hi);
	}
	
	private void merge(Comparable[] a, int lo, int mid, int hi){
		int i = lo;
		int j = mid + 1;
		for(int k = lo; k <= hi; k++){
			aux[k] = a[k];
		}
		for(int k = lo; k <= hi; k++){
			if(i > mid){
				a[k] = aux[j++];
			}else if(j > hi){
				a[k] = aux[i++];
			}else if(less(a[i],a[j])){
				a[k] = aux[i++];
			}else{
				a[k] = aux[j++];
			}
		}
	}
	
	public static void main(String[] args) {
		
	}

}
