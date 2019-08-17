package leetcode;

/**
 * @Author: Songxc
 * @Date: 19:58 2019/8/17
 * @Description:  乘积最大子序列
 *  给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 *
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 *
 *  思路：
 *   使用两个中间变量imax,imin记录以当前元素结尾的最大乘积子序列值和最小乘积子序列值，
 *   使用中间变量max记录每次遍历的最大值，用于输出。
 *   由于数组中可能有元素小于0，在遍历的过程中碰到该情况，需要将两值imax，imin进行交换。
 *
 *   时间复杂度为0（n）
 */
public class T152_MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }

            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(max, imax);
        }

        return max;
    }

}
