package dp;

/**
 * @Author: Songxc
 * @Date: 15:21 2020/4/5
 * @Description: 最长公共子序列
 */
public class MaxCommonSubSequence {

    public static String maxCommonSubSequence(String s1, String s2) {
        if (s1.length() <= 0 || s2.length() <= 0) {
            return null;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                dp[i][j] = 0;
            }
        }


        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = len1, j = len2; i > 0 && j > 0; ) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        String result = maxCommonSubSequence("acb", "aaabdc");
        System.out.println(result);
    }
}
