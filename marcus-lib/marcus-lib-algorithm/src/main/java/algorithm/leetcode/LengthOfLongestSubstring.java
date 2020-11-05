package algorithm.leetcode;

public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        if (s != null) {
            if (s.length() >= 1) {
                maxLength = 1;
            }
            int j = 0;
            for (int i = 1; i < s.length(); i++) {
                String str = s.substring(j, i);
                String c = s.substring(i, i + 1);
                int index = str.indexOf(c);
                if (index > -1) {
                    j = j + index + 1;
                }
                int length = i - j + 1;
                maxLength = length > maxLength ? length : maxLength;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

        String s1 = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s1));

        String s2 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s2));

        String s3 = " ";
        System.out.println(lengthOfLongestSubstring(s3));

        String s4 = "au";
        System.out.println(lengthOfLongestSubstring(s4));

        String s5 = "aab";
        System.out.println(lengthOfLongestSubstring(s5));

        String s6 = "dvdf";
        System.out.println(lengthOfLongestSubstring(s6));
    }
}
