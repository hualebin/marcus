package algorithm.leetcode;

/**
 * 青蛙跳台阶问题
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：1
 * 提示：
 *
 * 0 <= n <= 100
 *
 * @author marcus
 * @date 2020-12-23
 */
public class NumWays {
	public static int numWays(int n) {
		int a = 0;
		int b = 1;
		int sum = 1;
		for (int i = 1; i <= n; i++) {
			sum = (a + b) % 1000000007;
			a = b;
			b = sum;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(numWays(0));
		System.out.println(numWays(1));
		System.out.println(numWays(2));
		System.out.println(numWays(3));
		System.out.println(numWays(4));
		System.out.println(numWays(5));
		System.out.println(numWays(6));
		System.out.println(numWays(7));
	}
}
