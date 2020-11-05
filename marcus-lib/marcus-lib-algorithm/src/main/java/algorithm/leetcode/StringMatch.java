package algorithm.leetcode;

public class StringMatch {

    /**
     * 时间复杂度O(n*m)
     *
     * @param primary
     * @param pattern
     * @return
     */
    public static boolean bruteForce(String primary, String pattern) {
        if (isBlank(primary) || isBlank(pattern)) {
            return false;
        }

        int i = 0;
        int j = primary.length() - pattern.length();
        while(i <= j) {
            int p = i;
            int q = 0;
            while(q < pattern.length() && primary.charAt(p) == pattern.charAt(q)) {
                q++;
                p++;
            }
            if (q == pattern.length()) {
                return true;
            }
            i++;
        }
        return false;
    }

    public static boolean rabinKarp(String primary, String pattern) {
        if (isBlank(primary) || isBlank(pattern)) {
            return false;
        }
        return true;
    }

    public static boolean isBlank(CharSequence str) {
        int length;
        if (str != null && (length = str.length()) != 0) {
            for(int i = 0; i < length; ++i) {
                if (!isBlankChar(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    public static boolean isBlankChar(int c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c) || c == 65279 || c == 8234;
    }

    public static void main(String[] args) {
        String primary = "1000035667";
        String pattern = "003";
        System.out.println(bruteForce(primary, pattern));
    }
}
