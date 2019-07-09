package leetcode;

/**
 * @Author: Songxc
 * @Date: 0:12 2019/7/10
 * @Description:  正则表达式匹配
 *  思路：
 *   使用dp数组保存之前匹配的结果
 *    匹配情况有两种：
 *     当前字符为*和不是*
 */
public class T10_IsMatch {
    //动态规划
    public boolean isMatch(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                boolean first_match = (i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
                } else {
                    dp[i][j] = first_match && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

}
