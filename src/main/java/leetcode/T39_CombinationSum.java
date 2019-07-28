package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Songxc
 * @Date: 13:16 2019/7/28
 * @Description:
 *  给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 *     所有数字（包括 target）都是正整数。
 *     解集不能包含重复的组合。
 *
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 *
 *  思路：
 *   回溯法： 不断回溯剪枝
 */
public class T39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0){
            return null;
        }

        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();

        findCombinations(candidates, target, res, 0, new Stack<>());

        return res;

    }

    public void findCombinations(int[] candidates, int residue,List<List<Integer>> res, int start, Stack pre){
        if(residue == 0){
            res.add(new ArrayList<>(pre));
            return;
        }
        for(int i=start; i<candidates.length && residue - candidates[i]>=0; i++){
            pre.add(candidates[i]);
            findCombinations(candidates, residue - candidates[i], res, i, pre);
            pre.pop();
        }

    }
}
