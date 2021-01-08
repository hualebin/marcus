package algorithm.leetcode;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 进阶：
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *  
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 */
public class SearchRange {

    public static int[] solution(int[] nums, int target) {
        if (nums.length > 0) {
            int low = 0;
            int high = nums.length - 1;
            while(low <= high) {
                int middle = (low + high) / 2;
                if (nums[middle] == target) {
                    int max = middle;
                    for (int i = max + 1;i <= high; i++) {
                        if (nums[i] != target) {
                            max = i - 1;
                            break;
                        } else {
                            max = i;
                        }
                    }
                    int min = middle;
                    for (int i = min - 1; i >= low; i--) {
                        if (nums[i] != target) {
                            min = i + 1;
                            break;
                        } else {
                            min = i;
                        }
                    }
                    return new int[]{min, max};
                } else if (nums[middle] < target) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] result = solution(nums, 8);
        System.out.print("result: [" );
        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }
        System.out.print("]" );
    }
}
