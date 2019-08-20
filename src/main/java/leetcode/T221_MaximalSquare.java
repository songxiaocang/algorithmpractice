package leetcode;

/**
 * @Author: Songxc
 * @Date: 23:42 2019/8/20
 * @Description: 最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-square
 *
 * 思路：
 *  动态规划 有二维数组和一维数组解法， 本题只贴出一维数组解法
 *  动态规划方程：
 *  dp(i, j)=min(dp(i−1, j), dp(i−1, j−1), dp(i, j−1))+1
 *   =>  dp[j]=min(dp[j−1],dp[j],prev) + 1
 *   计算 第 i 行（row）的 dp 方法中，我们只使用了上一个元素和第 (i−1)^ th 行，因此我们不需要二维 dp 矩阵，因为一维 dp 足以满足此要求。
 *
 * 我们扫描一行原始矩阵元素时，我们根据公式：dp[j]=min(dp[j−1],dp[j],prev)dp[j]=min(dp[j-1],dp[j],prev)dp[j]=min(dp[j−1],dp[j],prev) 更新数组 dp，其中 prev 指的是 dp[j−1]dp[j-1]dp[j−1]，对于每一行，我们重复相同过程并在 dp 矩阵中更新元素。
 *
 *  时间复杂度：O(mn)。
 *  空间复杂度：O(n)，使用了一个一维数组 dp。
 *
 */
public class T221_MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return 0;
        }
        int rows = matrix.length, cols = matrix[0].length > 0 ? matrix[0].length : 0;
        int maxLen = 0, prev = 0;
        int[] dp = new int[cols + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxLen = Math.max(maxLen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }

        return maxLen * maxLen;
    }
}
