package algorithm.leetcode;

/**
 * 二维数组中的查找
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 * 限制：
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 *
 * @author marcus
 * @date 2020-12-22
 */
public class FindNumberIn2DArray {

	// 时间复杂度O(n*m)
	public boolean solution1(int[][] matrix, int target) {
		if (matrix == null) {
			return false;
		}
		int n = matrix.length;
		if (n == 0) {
			return false;
		}
		int m = matrix[0].length;
		if (m == 0) {
			return false;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == target) {
					return true;
				}
				if (matrix[i][j] > target){
					break;
				}
			}
		}
		return false;
	}

	// 由于给定的二维数组具备每行从左到右递增以及每列从上到下递增的特点，当访问到一个元素时，可以排除数组中的部分元素。
	// 从二维数组的右上角开始查找。
	// 如果当前元素等于目标值，则返回 true。
	// 如果当前元素大于目标值，则移到左边一列。
	// 如果当前元素小于目标值，则移到下边一行。
	// 时间复杂度为O(n + m)
	public boolean solution2(int[][] matrix, int target) {
		if (matrix == null) {
			return false;
		}
		int n = matrix.length;
		if (n == 0) {
			return false;
		}
		int m = matrix[0].length;
		if (m == 0) {
			return false;
		}
		for (int i = 0; i < n; i++) {
			for (int j = m - 1; j >= 0; j--) {
				if (matrix[i][j] == target) {
					return true;
				}
				if (matrix[i][j] < target) {
					break;
				}
			}
		}
		return false;
	}
}
