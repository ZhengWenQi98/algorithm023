package cn.zwq.algorithm.middle;

/**
 * 647.回文子串
 *
 * @author G20200343200113
 */
public class LeetCode647 {

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int length = s.length();
        int result = 0;
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    result++;
                }
            }
        }

        return result;
    }

    /**
     * 中心拓展
     * 中心为 1 个字符 / 2 个字符
     * 以字符串的中间为中心，向左右拓展，左右相同说明是回文子串，然后再继续向左右拓展,
     * 知道所有的中心点都向左右拓展完毕
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int length = s.length();
        int result = 0;
        for (int i = 0; i < 2 * length - 1; i++) {
            int left = i / 2;
            int right = i / 2 + i % 2;
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                left++;
                right++;
                result++;
            }
        }
        return result;
    }
}
