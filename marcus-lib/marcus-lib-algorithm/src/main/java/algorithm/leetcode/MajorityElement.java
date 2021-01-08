package algorithm.leetcode;

import algorithm.array.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    /**
     * 哈希表
     * @param nums
     * @return
     */
    public static int solution(int[] nums) {
        int m = nums.length;
        int n = m / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int num = map.getOrDefault(nums[i], 0) + 1;

            if (i >= n && num > n) {
                return nums[i];
            }
            map.put(nums[i], num);
        }
        return -1;
    }

    /**
     * 排序
     * @param nums
     * @return
     */
    public static int solution1(int[] nums) {
        Arrays.sort(nums); // 复杂度O(nlogn)
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        System.out.println("nums1: " + solution(nums1));
        int[] nums2 = {2,2,1,1,1,2,2,1,1};
        System.out.println("nums2: " + solution1(nums2));
    }
}
