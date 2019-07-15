package leetcode;

/**
 * @Author: Songxc
 * @Date: 1:54 2019/7/16
 * @Description: 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * <p>
 * 思路：
 * 从后往前遍历，找到中断降序序列的第一个数字i，然后从该数字后面的数字串中倒序找到大于它的第一个数字j，
 * 将这两个数字i，j交换，然后从i以后的数字串需要反转以下。
 * 总的时间复杂度维持在0(n)级别，空间复杂度在常数级别，可以忽略。
 */
public class T31_NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j > 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] data, int m, int n) {
        int temp = data[m];
        data[m] = data[n];
        data[n] = temp;
    }

    public void reverse(int[] data, int begin) {
        int end = data.length - 1;
        while (begin < end) {
            swap(data, begin, end);
            begin++;
            end--;
        }
    }
}
