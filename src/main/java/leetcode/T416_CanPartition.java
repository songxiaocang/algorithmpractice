package leetcode;

/**
 * @Author: Songxc
 * @Date: 18:22 2019/9/8
 * @Description: 分割等和子集
 *  给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 *     每个数组中的元素不会超过 100
 *     数组的大小不会超过 200
 *
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 *
 *
 * 思路：
 * 动态规划  该题为0-1背包变形题
 * 动态规划转移方程：
 *  dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i]]
 *
 *  时间复杂度为0（NC）  N为元素个数，C为该数组各元素总和的一半
 *  空间复杂度为0（C）
 *
 */
public class T416_CanPartition {
    public boolean canPartition(int[] nums) {
        int size = nums.length;

        int s = 0;
        for (int num : nums) {
            s += num;
        }
        if ((s & 1) == 1) {
            return false;
        }

        int target = s / 2;

        boolean[] dp = new boolean[target + 1];

        // 状态转移方程：dp[i - 1][j] = dp[i - 1][j] or dp[i - 1][j - nums[i]]
        // 单独 1 个数可以构成子集，根据状态转移方程，当 j == nums[i] 成立的时候，会来看 dp[i - 1][0] 的值
        // 因此根据语义，dp[0] 应该设置为 True
        dp[0] = true;

        for (int j = 1; j < target + 1; j++) {
            if (nums[0] == j) {
                dp[j] = true;
                break;
            }
        }
        for (int i = 1; i < size; i++) {

            // 先看最后一个数是不是返回 True，如果是，后面就没有必要计算了，方法可以直接返回 True
            if(target >= nums[i]){
                dp[target] = dp[target] || dp[target - nums[i]];
            }
            if (dp[target]) {
                return true;
            }

            // 然后再写倒数第 2 个数，倒数第 3 个数
            for (int j = target - 1; j >= 0 && j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }

}
