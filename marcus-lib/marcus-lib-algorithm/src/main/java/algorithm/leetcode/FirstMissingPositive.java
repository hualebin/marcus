package algorithm.leetcode;

/**
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
 */
public class FirstMissingPositive {
    public static int solution1(int[] nums) {
        int n = nums.length;
        // 将小于等于0的数变为n+1
        for (int i = 0; i < n; i++) {
            if(nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        // 将小于等于n的数放入该数减一的位置，并将该数变为负数
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                nums[nums[i] - 1] = -nums[nums[i] - 1];
            }
        }
        // 遍历找到第一个大于零的下标加1,则是找到没有的那个小数
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        //遍历找不到则返回n+1
        return n + 1;
    }
}
