package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 替换空格
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * 限制：
 * 0 <= s 的长度 <= 10000
 *
 * @author marcus
 * @date 2020-12-22
 */
public class ReplaceSpace {

	// 时间复杂度O（n），空间复杂度O(n)
	public static String solution(String s) {
		int startIndex = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			if (Character.isSpaceChar(s.charAt(i))) {
				sb.append(s.substring(startIndex, i));
				sb.append("%20");
				startIndex = i + 1;
			}
		}
		if (startIndex < s.length()) {
			sb.append(s.substring(startIndex, s.length()));
		}
		return sb.toString();
	}

	// 时间复杂度O（n），空间复杂度O(n)
	public static String solution1(String s) {
		int n = s.length();
		char[] chars = new char[3 * n];
		int j = 0;
		for (int i = 0; i < n; i++) {
			if (Character.isSpaceChar(s.charAt(i))) {
				chars[j++] = '%';
				chars[j++] = '2';
				chars[j++] = '0';
			} else {
				chars[j++] = s.charAt(i);
			}
		}
		return new String(chars);
	}

	public static void main(String[] args) {
		String s = " We are happy. ";
		System.out.println(solution1(s));
	}
}
