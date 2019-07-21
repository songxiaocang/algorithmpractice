package leetcode;

/**
 * @Author: Songxc
 * @Date: 21:26 2019/7/21
 * @Description: 搜索旋转排序数组 II
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * <p>
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
 * <p>
 * 思路：
 * 二分查找算法  时间复杂度为0(logN)
 */
public class T81_searchIndex {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return false;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] == target) {
                return true;
            }
            if (nums[pivot] == nums[left] && nums[pivot] == nums[right]) {
                left++;
                right--;
            } else if (nums[left] <= nums[pivot]) {
                if (nums[left] <= target && target < nums[pivot]) {
                    right = pivot - 1;
                } else {
                    left = pivot + 1;
                }
            } else {
                if (nums[pivot] < target && target <= nums[right]) {
                    left = pivot + 1;
                } else {
                    right = pivot - 1;
                }
            }

        }

        return false;
    }
}
