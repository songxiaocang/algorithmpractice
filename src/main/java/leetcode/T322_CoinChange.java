package leetcode;

import java.util.Arrays;

/**
 * @Author: Songxc
 * @Date: 22:31 2019/9/3
 * @Description: 零钱兑换
 *  给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 *
 * 思路：
 *   动态规划
 *
 *   动态规划方程：
 *    dp[i] = Math.min(dp[i- coin[j]]) + 1
 *
 *    int[] coins 为 货币币值数组  （n为长度），int  amount 为指定金额
 *    时间复杂度为 0（amount * n）
 *    空间复杂度为 0（amount）
 *
 */
public class T322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length <= 0 || amount <= 0) {
            return 0;
        }

        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
