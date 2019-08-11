package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Songxc
 * @Date: 18:13 2019/8/11
 * @Description:  最长连续序列
 *  给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 *
 * 思路：
 *  有两种解法： 排序 和 哈希表
 *   都需要使用到中间变量 longestStreak curStreak来记录保存最长连续序列长度和当前遍历到的节点的最长连续序列长度，
 *   在每次遍历的时候，不断去更新longestStreak的值。
 *
 *   如果题目要求不更改原数组，则需要用到哈希表法
 *
 *   1） 排序 时间复杂度度0（NlogN）， 空间复杂度为0（1）
 *   时间复杂度：
 *  算法核心的 for循环恰好运行 n 次，所以算法的时间复杂度由 sort 函数的调用决定，通常会采用 O(nlgn) 时间复杂度的算法。
 *  空间复杂度：
 *  消耗了常量级别的空间
 *   2） 哈希表 时间复杂度度0（N）， 空间复杂度为0（N）
 *   时间复杂度：
 *    尽管在 for 循环中嵌套了一个 while 循环，时间复杂度看起来像是二次方级别的。但其实它是线性的算法。
 *    因为只有当 currentNum 遇到了一个序列的开始， while 循环才会被执行（也就是 currentNum-1 不在数组 nums 里），
 *    while 循环在整个运行过程中只会被迭代 nnn 次。这意味着尽管看起来时间复杂度为O(n⋅n) ，实际这个嵌套循环只会运行 O(n+n)=O(n)次。
 *    所有的计算都是线性时间的，所以总的时间复杂度是 O(n)的。
 *   空间复杂度：
 *   哈希表保存N个数字，占用了0（n）的存储空间
 *
 */
public class T128_LongestConsecutive {
    //哈希表法
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int longestStreak = 0;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int curNum = num;
                int curStreak = 1;

                while (numSet.contains(curNum + 1)) {
                    curNum++;
                    curStreak++;
                }

                longestStreak = Math.max(longestStreak, curStreak);
            }
        }

        return longestStreak;
    }

    //排序法
    public int longestConsecutive2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longestStreak = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                if (nums[i] == nums[i-1]+1) {
                    currentStreak += 1;
                }
                else {
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;
                }
            }
        }

        return Math.max(longestStreak, currentStreak);
    }


}
