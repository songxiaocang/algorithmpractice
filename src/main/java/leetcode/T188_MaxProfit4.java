package leetcode;

/**
 * @Author: Songxc
 * @Date: 12:06 2019/8/11
 * @Description: 买卖股票的最佳时机 IV(限制买卖手数K)
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,4,1], k = 2
 * 输出: 2
 * 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * <p>
 * 思路：
 * 该题需要对买卖手数进行判断，一次买卖至少需要2天，如果k大于交易总天数，则k对于求解无限制，则该题等效于求解无线手数。
 * 反之，需要对买卖手数K进行循环遍历。
 * <p>
 * 时间复杂度0（n）,空间复杂度为0（n）
 */
public class T188_MaxProfit4 {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1 || k <= 0) {
            return 0;
        }
        int len = prices.length;
        if (k > len / 2) {
            return maxProfitNoLimit(prices);
        }

        int[][][] dp = new int[len][k + 1][2];
        for (int i = 0; i < len; i++) {
            for (int j = k; j >= 1; j--) {
                if (i == 0) {
                    dp[0][j][0] = 0;
                    dp[0][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        return dp[len - 1][k][0];
    }

    public int maxProfitNoLimit(int[] prices) {
        int dp0 = 0, dp1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int temp = dp0;
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, temp - prices[i]);
        }
        return dp0;
    }
}
