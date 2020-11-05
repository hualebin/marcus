package algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 两个数组的交集
 */
public class Intersection {

    // 利用hashSet去重, 时间复杂度O(m + n), kong
    public static int[] solution1(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        return nums1.length > nums2.length ? getIntersection(nums1, nums2) : getIntersection(nums2, nums1);
    }

    public static int[] getIntersection(int[] largeNums, int[] smallNums) {
        Set<Integer> set = new HashSet<>();
        for (int largeNum : largeNums) {
            set.add(largeNum);
        }
        Set<Integer> intersectionSet = new HashSet<Integer>();
        for (int smallNum : smallNums) {
            if (set.contains(smallNum)) {
                intersectionSet.add(smallNum);
            }
        }
        int[] result = new int[intersectionSet.size()];
        int index = 0;
        for (int num : intersectionSet) {
            result[index++] = num;
        }
        return result;
    }

}
