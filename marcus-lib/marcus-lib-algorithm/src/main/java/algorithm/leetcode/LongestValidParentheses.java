package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 */
public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (')' == c && !stack.isEmpty() && '(' == stack.pop()) {
                count++;
                continue;
            }

            if ('(' == c) {
                stack.push(c);
            }
        }
        return count * 2;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(())(()())()()()("));
    }
}
