package leetcode;

/**
 * @Author: Songxc
 * @Date: 16:18 2019/8/3
 * @Description: 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * <p>
 * 思路：
 * 动态规划
 * 包括二维动态规划、一维动态规划、原地动态规划
 * 状态转移方程： dp[i][j] = grid[i][j] + Math.min(dp[i][j+1], dp[i+1][j]);
 * 时间复杂度为o（mn）
 */
public class T64_MinPathSum {
    //原地动态规划 空间复杂度为o（1）
    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j != grid[0].length - 1) {
                    grid[i][j] = grid[i][j] + grid[i][j + 1];
                } else if (i != grid.length - 1 && j == grid[0].length - 1) {
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                } else if (i != grid.length - 1 && j != grid[0].length - 1) {
                    grid[i][j] = grid[i][j] + Math.min(grid[i][j + 1], grid[i + 1][j]);
                }
            }
        }
        return grid[0][0];
    }

    //一维动态规划  空间复杂度为0（n）
    public int minPathSum2(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j != grid[0].length - 1)
                    dp[j] = grid[i][j] + dp[j + 1];
                else if (j == grid[0].length - 1 && i != grid.length - 1)
                    dp[j] = grid[i][j] + dp[j];
                else if (j != grid[0].length - 1 && i != grid.length - 1)
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
                else
                    dp[j] = grid[i][j];
            }
        }
        return dp[0];
    }

    //二维动态规划 空间复杂度为0（mn）
    public int minPathSum3(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j != grid[0].length - 1)
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                else if (j == grid[0].length - 1 && i != grid.length - 1)
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                else if (j != grid[0].length - 1 && i != grid.length - 1)
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                else
                    dp[i][j] = grid[i][j];
            }
        }
        return dp[0][0];
    }


}
