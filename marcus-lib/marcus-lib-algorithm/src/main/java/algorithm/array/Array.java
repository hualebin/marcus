package algorithm.array;

import java.util.ArrayList;

/**
 * Array
 *
 * @author marcus
 * @date 2020-06-28
 */
public class Array {
	public static void main(String[] args) {
		Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
		for (Integer i : arr) {
			System.out.println(i.hashCode());
		}
	}
}
