package leetcode;

import java.util.Arrays;

/**
 * @Author: Songxc
 * @Date: 1:24 2019/8/27
 * @Description: 最长上升子序列
 *  给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 *
 * 思路：
 *  有多种解决办法
 *  1） 动态规划
 *   时间复杂度为0（n2）， 空间复杂度为0（n）
 *
 *  2） 动态规划 + 二分搜索
 *  时间复杂度为0（nlogn）， 空间复杂度为0（n）
 */
public class T300_LengthOfLIS {
    //动态规划 + 二分搜索
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for(int num : nums){
            int i = Arrays.binarySearch(dp, 0, len, num);
            if(i < 0){
                i = -(i+1);
            }
            dp[i] = num;
            if(i == len){
                len++;
            }
        }
        return len;
    }

    //动态规划
    public int lengthOfLIS2(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
