package leetcode;

/**
 * @Author: Songxc
 * @Date: 10:23 2019/8/18
 * @Description: 打家劫舍
 *  你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 *
 *  思路：
 *   动态规划。
 *    记f(k) = 从前 k 个房屋中能抢劫到的最大数额，Ai = 第 i 个房屋的钱数。
 *    首先看 n = 1 的情况，显然 f(1) = A1​。
 *
 * 再看 n = 2，f(2) = max(A1​, A2)。
 * 对于 n = 3，有两个选项:
 *     抢第三个房子，将数额与第一个房子相加。
 *     不抢第三个房子，保持现有最大数额。
 * 显然，你想选择数额更大的选项。于是，可以总结出公式：
 *     f(k) = max(f(k – 2) + Ak, f(k – 1))
 * 我们选择 f(–1) = f(0) = 0 为初始情况，这将极大地简化代码。
 *
 * 时间复杂度0（n），空间复杂度0（1）
 *

 */
public class T198_Rob {
    public int rob(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int curMax = 0, preMax = 0;
        for (int num : nums) {
            int temp = curMax;
            curMax = Math.max(preMax + num, curMax);
            preMax = temp;
        }

        return curMax;
    }
}
