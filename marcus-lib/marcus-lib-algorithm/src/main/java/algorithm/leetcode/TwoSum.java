package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author marcus
 *
 * 给定一个整型数组，找出能相加起来等于一个特定目标数字的两个数。
 * 函数 twoSum 返回这两个相加起来等于目标值的数字的索引，且 index1 必须小于 index2。 请记住你返回的答案（包括 index1 和 index2）都不是从 0 开始的。
 * 你可以假定每个输入都有且仅有一个解决方案。
 * 输入: numbers={2, 7, 11, 15}, target=9
 * 输出: index1=1, index2=2
 */
public class TwoSum {
	
	public static int[] twoSum(int nums[], int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int numsSize = nums.length;
		for (int i = 0; i < numsSize; i++) {
			map.put(nums[i], i);
		}
		int[] result = new int[2];
		for (int i = 0; i < numsSize; i++) {
			int num = target - nums[i];
			if (map.containsKey(num) && map.get(num) != i) {
				int index = map.get(num);
				if (index < i) {
					result[0] = index;
					result[1] = i;
				} else {
					result[0] = i;
					result[1] = index;
				}
			}
		}
		
		return result;
	}

	public static int[] twoSum1(int nums[], int target) {
		int numsSize = nums.length;
		int[] result = new int[2];
		for (int i = 0; i < numsSize - 1; i++) {
			int num = target - nums[i];
			for (int j = i + 1; j < numsSize; j++) {
				if (nums[j] == num) {
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}

		return result;
	}

	
	public static void main(String[] args) {
		int[] numbers = {2, 7, 11, 15};
		int target = 14;
		int[] result =  TwoSum.twoSum1(numbers, target);
		System.out.println("index1=" + result[0] + "  index2=" + result[1]);
	}

}
