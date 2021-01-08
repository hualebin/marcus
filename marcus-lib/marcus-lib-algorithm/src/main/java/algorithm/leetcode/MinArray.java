package algorithm.leetcode;

/**
 * MinArray
 *
 * @author marcus
 * @date 2020-12-23
 */
public class MinArray {
    // 二分查找
	public static int minArray(int[] numbers) {
		int low = 0;
		int high = numbers.length - 1;
		while(low < high) {
			int pivot = low + (high - low) / 2;
			if (numbers[pivot] < numbers[high]) {
				high = pivot;
			} else if (numbers[pivot] > numbers[high]) {
				low = pivot + 1;
			} else {
				high -= 1;
			}
		}
		return numbers[low];
	}

	public static void main(String[] args) {
		int[] numbers = new int[]{3, 4, 5, 1, 2};
		System.out.println(minArray(numbers));

		int[] numbers1 = new int[]{2, 2, 2, 0, 1};
		System.out.println(minArray(numbers1));

		int[] numbers2 = new int[]{1, 2, 3, 4, 5};
		System.out.println(minArray(numbers2));

		int[] numbers3 = new int[]{2, 2, 2, 2, 2};
		System.out.println(minArray(numbers3));

		int[] numbers4 = new int[]{3, 1, 3};
		System.out.println(minArray(numbers4));
	}
}
