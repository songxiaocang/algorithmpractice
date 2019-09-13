package leetcode;

import java.util.HashMap;

/**
 * @Author: Songxc
 * @Date: 18:27 2019/9/13
 * @Description: 和为K的子数组
 *  给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * 示例 1 :
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 *
 * 说明 :
 *    1、数组的长度为 [1, 20,000]。
 *    2、数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 *
 * 思路：
 *  推荐两种解法
 *   1） 累加和   时间复杂度为0（n2）, 空间复杂度为0（1）
 *   2）哈希表    时间复杂度为0（n）， 空间复杂度为0（n）
 *
 */
public class T560_SubArraySum {
    //哈希表
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }


    //迭代遍历 记录累加和 不需要额外空间
    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum=0;
            for (int end = start; end < nums.length; end++) {
                sum+=nums[end];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }

}
