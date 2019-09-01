package leetcode;

/**
 * @Author: Songxc
 * @Date: 11:37 2019/9/1
 * @Description: 戳气球
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 *
 * 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 *
 * 求所能获得硬币的最大数量。
 *
 * 说明:
 *
 *     你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 *     0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 *
 * 示例:
 *
 * 输入: [3,1,5,8]
 * 输出: 167
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *      coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/burst-balloons
 *
 * 思路：
 *  动态规划
 *  nums[] 数组表示每个序号气球对应的数值数组
 *  dp[i][j] 表示序号[i+1, j-1]中戳气球的最大收益
 *  设k为[i, j]之间最后一次的收益
 *  可得出动态规划方程：
 *  dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + nums[i] * nums[k] * nums[j]);
 *
 */
public class T312_MaxCoins {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int[] newNums = new int[nums.length + 2];
        int n = nums.length + 2;
        newNums[0] = 1;
        newNums[n - 1] = 1;
        for (int i = 1; i < n - 1; i++) {
            newNums[i] = nums[i - 1];
        }
        int[][] dp = new int[n][n];
        for (int len = 2; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + newNums[i] * newNums[k] * newNums[j]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
