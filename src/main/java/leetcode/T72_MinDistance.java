package leetcode;

/**
 * @Author: Songxc
 * @Date: 22:29 2019/8/3
 * @Description: 编辑距离
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * 示例 1:
 * <p>
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * <p>
 * 思路：
 * 动态规划
 * dp[i][j] 表示 word1第i个字母和 word2第j个字母的编辑距离。
 * 状态转移方程:
 * word1[i] == word2[j]时，
 * dp[i][j] = 1+ Math.min(dp[i-1],dp[i][j-1], dp[i-1][j]+dp[i][j-1]-1);
 * word1[i] ！= word2[j]时，
 * dp[i][j] = 1+ Math.min(dp[i-1],dp[i][j-1], dp[i-1][j]+dp[i][j-1]);
 * <p>
 * 时间复杂度为o(mn)， 空间复杂度为o（mn）
 */
public class T72_MinDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m * n == 0) {
            return m + n;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int leftDown = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    leftDown += 1;
                }
                dp[i][j] = Math.min(left, Math.min(leftDown, down));
            }
        }

        return dp[m][n];
    }
}
