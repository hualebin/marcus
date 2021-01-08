package algorithm.leetcode;

/**
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 *
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 *
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 *
 * S 只包含小写字母并且长度在[1, 500]区间内。
 */
public class ReorganizeString {

    public String solution(String S) {
        if (S.length() == 1) {
            return S;
        }
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                boolean flag = true;
                for (int j = i + 2; j < chars.length; j++) {
                    if (chars[j] != chars[i + 1]) {
                        chars[i + 1] = chars[j];
                        chars[j] = chars[i];
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return "";
                }
            }
        }
        return String.valueOf(chars);
    }
}
