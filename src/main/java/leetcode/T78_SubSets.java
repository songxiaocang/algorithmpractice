package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Songxc
 * @Date: 18:24 2019/8/4
 * @Description: 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * <p>
 * 思路；
 * 回溯法  时间复杂度为0（2^n）, 空间复杂度为0（n）
 */
public class T78_SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <= 0) {
            return res;
        }
        backTrace(nums, res, 0, new ArrayList<>());
        return res;
    }

    public void backTrace(int[] nums, List<List<Integer>> res, int index, List<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int i = index; i < nums.length; i++) {
            tmp.add(nums[i]);
            backTrace(nums, res, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
