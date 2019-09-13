package leetcode;

/**
 * @Author: Songxc
 * @Date: 13:02 2019/9/13
 * @Description: 目标和
 *  思路：
 *      给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 示例 1:
 *
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 *
 * 思路：
 *  0-1 问题处理
 *   动态规划方程：
 *   dp[i] += dp[i-num]
 */
public class T494_FindTargetSumWays {
    /**
     * 解题思路：
     * 暴力解法：每一位有两种操作（+、-），深度遍历整个数组，得到满足条件的个数，时间复杂度O(2^n)
     *
     * 优化解法：0-1背包问题改版
     * 1、求出背包中要取的总数和:
     *  假设取正数和P，负数和N，P-N = target
     *  两边同时加上 P+N ==> P+N+P-N = target + P+N（其中P+N=nums的总和）
     *  2*P = target+sum ==> P = (target+sum)/2（P就是要取得总和）
     * 2、dp[i]代表合成i有多少种方法，动态转移方程dp[i] += dp[i - num];
     *  dp[i]的总和 == 除了i以外所有可能性总和，举例：[n1,n2,n3]，dp[i]=dp[i-n1]+dp[i-n2]+dp[i-n3]
     *
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;

        for(int num : nums) {
            sum += num;
        }

        if(Math.abs(target) > sum || (sum + target) % 2 != 0) {
            return 0;
        }

        //1
        int P = (sum + target) / 2;
        int[] dp = new int[P + 1];
        dp[0] = 1;

        //2、
        for (int num : nums) {
            for (int i = P; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }

        return dp[P];
    }


}
