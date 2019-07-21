package leetcode;

/**
 * @Author: Songxc
 * @Date: 23:55 2019/7/21
 * @Description: 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 *
 * 思路： 二分查找法
 */
public class T34_SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] indexRange = {-1, -1};
        if (nums == null || nums.length <= 0) {
            return indexRange;
        }
        int leftIndex = findIndex(nums, target, true);
        if (leftIndex == nums.length || nums[leftIndex] != target) {
            return indexRange;
        }
        indexRange[0] = leftIndex;
        indexRange[1] = findIndex(nums, target, false) - 1;
        return indexRange;

    }

    public int findIndex(int[] nums, int target, boolean left) {
        int low = 0, high = nums.length;
        while (low < high) {
            int pivot = (low + high) / 2;
            if (target < nums[pivot] || (left && nums[pivot] == target)) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return low;
    }
}
