package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Songxc
 * @Date: 21:42 2019/7/28
 * @Description: 全排列
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * <p>
 * 思路：
 * 回溯法：
 * 回溯遍历
 * 在排列中放置第 i 个整数， 即 swap(nums[first], nums[i]).
 * 继续生成从第 i 个整数开始的所有排列: backtrack(first + 1).
 * 现在回溯，即通过 swap(nums[first], nums[i]) 还原.
 *
 *  时间复杂度：n的k排列：  0(∑k=1~N​ P(N,k)) ，其值介于N！和 N*N!之间。
 *  空间复杂度为：N! （n的阶乘）
 *

 */
public class T46_Permute {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return null;
        }
        int len = nums.length;
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> numsArr = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            numsArr.add(nums[i]);
        }
        backTrace(numsArr, len, 0, output);
        return output;
    }

    public void backTrace(List<Integer> nums, int len, int start, List<List<Integer>> output) {
        if (start == len) {
            output.add(new ArrayList<>(nums));
        }
        for (int i = start; i < len; i++) {
            //交换顺序
            Collections.swap(nums, start, i);
            //回溯
            backTrace(nums, len, start + 1, output);
            //还原
            Collections.swap(nums, start, i);
        }
    }
}
