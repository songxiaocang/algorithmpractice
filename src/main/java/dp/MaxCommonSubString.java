package dp;

/**
 * @Author: Songxc
 * @Date: 15:32 2020/4/5
 * @Description: 最长公共子字符串
 */
public class MaxCommonSubString {

    public static String maxCommonSubString(String s1, String s2) {
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

        int max = -1, row = 0, col = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > max) {
                        row = i;
                        col = j;
                        max = dp[i][j];
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = row - max; i < row; i++) {
            sb.append(s1.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String result = maxCommonSubString("abd", "aaabdc");
        System.out.println(result);
    }
}
