package leetcode;

/**
 * @Author: Songxc
 * @Date: 18:22 2019/8/10
 * @Description: 买卖股票的最佳时机 II
 * 区别与121题，可以买卖多手，但同一时刻只能有一笔买卖单
 * <p>
 * 思路：
 * 依次遍历，如果遍历前后值正向增加，将差值累加到利润总和中，直到遍历结束。
 * 时间复杂度0(n)， 空间复杂度为0(1)
 */
public class T122_MaxProfit2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
