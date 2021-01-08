package algorithm.leetcode;

/**
 * 缺失的第一个正数
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * 示例 1:
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 提示：
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 *
 * @author marcus
 * @date 2020-12-16
 */
public class FirstMissingPositive {

	// 时间复杂度为O(n) 空间复杂度为O(1)
	public static int solution1(int[] nums) {
		int n = nums.length;
		// 第一步遍历数组将小于0的数字变为数组长度+1
		for (int i = 0; i < n; i++) {
			if (nums[i] <= 0) {
				nums[i] = n + 1;
			}
		}
		// 第二步遍历数组将小于等于数组长度的的数字对应位置变为负数
		for (int i = 0; i < n; i++) {
			int num = Math.abs(nums[i]);
			if (num <= n) {
				nums[num - 1] = -Math.abs(nums[num - 1]);
			}
		}
		// 第三步遍历数组找到第一个大于0的元素下标+1并返回
		for (int i = 0; i < n; ++i) {
			if (nums[i] > 0) {
				return i + 1;
			}
		}
		// 如果所有的数组里面的数字刚好全部小于0
		return n + 1;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{3, 4, -1, 1};
		System.out.println(solution1(nums));
	}
}
