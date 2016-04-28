package algorithm.part1;

/**
 * 二分查找
 * @author Administrator
 *
 */
public class BinarySearch {
	
	public static int rank(int key, int[] a)
	{
		//数组必须是有序的
		int lo = 0;
		int hi = a.length - 1;
		while(lo <= hi)
		{	//被查找的键要么不存在， 要么必然存在于a[lo..hi]之中
			int mid = lo + (hi - lo)/2;
			System.out.println("mid = " + mid);
			if(key < a[mid]){
				hi = mid - 1;
			}else if(key > a[mid]){
				lo = mid + 1;
			}else{
				return mid;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] whitelist = {10, 11, 12, 16, 18, 23, 29, 33, 48, 54, 57, 68, 77, 84, 98};
		System.out.println(rank(23, whitelist));
		System.out.println(Math.abs(-2147483648));	//整数溢出
		System.out.println(Math.abs(-2147483647));
		System.out.println(Math.abs(-2147483646));
		//System.out.println("1/0" + (1/0));
		System.out.println("1.0/0.0" + (1.0/0.0));
	}
}
