package algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatNumber {

    public static int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 5};

        System.out.println(solution(nums));
    }
}
