package algorithm.binarysearch;

/**
 * 二分查找
 *
 * 基于有序的数组实现二分查找
 * 算法时间复杂度为O(logn)
 *
 * @author marcus
 * @date 2020-05-18
 */
public class BinarySearch {

	// 普通二分查找
	public static int search(int[] data, int searchValue) {
		int low = 0;
		int high = data.length - 1;
		while(low <= high) {
			int mid = (low + high) / 2;
			if (data[mid] == searchValue) {
				return mid;
			} else if (data[mid] < searchValue) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	// 查找第一个值等于给定值的元素
	public static int firstEqualSearch(int[] data, int searchValue) {
		int low = 0;
		int high = data.length - 1;

		while(low <= high) {
			int mid = (low + high) / 2;
			if (data[mid] == searchValue) {
				while(mid > low && data[mid - 1] == searchValue) {
					System.out.println("mid: " + mid);
					mid--;
				}
				return mid;
			} else if (data[mid] < searchValue) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	// 查找最后一个值等于给定值的元素
	public static int lastEqualSearch(int[] data, int searchValue) {
		int low = 0;
		int high = data.length - 1;

		while(low <= high) {
			int mid = (low + high) / 2;
			if (data[mid] == searchValue) {
				while(mid < high && data[mid + 1] == searchValue) {
					mid++;
				}
				return mid;
			} else if (data[mid] < searchValue) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	// 查找第一个大于给定值的元素 TODO
	public static int fistGeSearch(int[] data, int searchValue) {
		int low = 0;
		int high = data.length - 1;

		while(low <= high) {
			int mid = (low + high) / 2;
			if (data[mid] == searchValue) {
				while(mid < high && data[mid + 1] == searchValue) {
					mid++;
				}
				return mid == (data.length - 1) ? -1 : mid + 1;
			} else if (data[mid] < searchValue) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
	// 查找最后一个小于给定值的元素 TODO
	public static int lastLeSearch(int[] data, int searchValue) {
		int low = 0;
		int high = data.length - 1;

		while(low <= high) {
			int mid = (low + high) / 2;
			if (data[mid] == searchValue) {
				while(mid > low && data[mid - 1] == searchValue) {
					mid--;
				}
				return mid - 1;
			} else if (data[mid] < searchValue) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}


	public static void main(String[] args) {
		int[] data = {1, 1, 1, 5, 7, 12, 67, 89, 107, 221, 221, 222, 876, 1098, 1098};
		System.out.println(firstEqualSearch(data, 1098));
		System.out.println(lastEqualSearch(data, 1098));
		System.out.println(fistGeSearch(data, 1));
		System.out.println(lastLeSearch(data, 1));
	}
}
