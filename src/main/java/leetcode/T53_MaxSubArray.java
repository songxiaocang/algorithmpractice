package leetcode;

/**
 * @Author: Songxc
 * @Date: 22:37 2019/7/29
 * @Description: 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 *
 * 思路：
 *  1）动态规划
 *   dp[i] =  data[i]            i=0或dp[i-1]<=0
 *          dp[i-1]+data[i]    i!=0且dp[i-1]>0
 *  2）分治法
 *   求解左边解、右边解、中间解，最后将三者合并
 */
public class T53_MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int ans = nums[0], sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            ans = Math.max(ans, sum);
        }

        return ans;

    }
}
