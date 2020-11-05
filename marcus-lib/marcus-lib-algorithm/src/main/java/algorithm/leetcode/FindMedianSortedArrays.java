package algorithm.leetcode;

public class FindMedianSortedArrays {
    public double solution(int[] nums1, int[] nums2) {
        int count = nums1.length + nums2.length;
        if (count < 2) {
            return nums1.length > 1 ? nums1[0] : nums2[0];
        }
        // 双指针移动
        int middleIndex = count / 2;
        int i = 0, j = 0;
        int middle = 0;
        int middleNext = 0;
        while (i < nums1.length && j < nums2.length) {
            if ((i + j) == middleIndex) {
                break;
            }
            if ((nums1[i] < nums2[j] && (i + 1) < nums1.length) || (nums1[i] >= nums2[j] && (j + 1) >= nums2.length)) {
                middle = nums1[++i];
            } else {
                middle = nums1[++j];
            }
        }

        if (count % 2 == 0) {
            return 0;
        } else {
            return middle;
        }
    }

    public static void main(String[] args) {
        int count = 3;
        int middle = count / 2;
        System.out.println(middle);
    }
}
