package algorithm.leetcode;

/**
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 *
 */
public class PivotIndex {

    public static int pivotIndex(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return -1;
        }

        for (int index = 1; index < n - 1; index++) {
            if (checkIndex(nums, n, index)) {
                return index;
            }
        }


        return -1;
    }

    public static boolean checkIndex(int[] nums, int n, int index) {
        int prev = 0;
        for (int i = index - 1; i > 0; i--) {
            prev = nums[i] + prev;
        }
        int next = 0;
        for (int i = index + 1; i< n; i++) {
            next = nums[i] + next;
        }

        return prev == next;
    }

    public static void main(String[] args) {

    }
}
