package leetcode;

/**
 * @Author: Songxc
 * @Date: 0:58 2019/8/18
 * @Description: 求众数  （同swordOffer T39）
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 *
 * 思路：
 *  1）利用数组特点求解  使用中间变量value保存众数结果
 *  2）Booyer-Moore投票算法
 *   本质上， Boyer-Moore 算法就是找 nums 的一个后缀 sufsufsuf ，其中 suf[0]suf[0]suf[0] 就是后缀中的众数。
 *   我们维护一个计数器，如果遇到一个我们目前的候选众数，就将计数器加一，否则减一。只要计数器等于 0 ，
 *   我们就将 nums 中之前访问的数字全部 忘记 ，并把下一个数字当做候选的众数。
 *
 *   时间复杂度为0（n），空间复杂度为0（1）  （只需要常量级别的额外空间）
 *

 */
public class T169_MajorityElement {
    //解法1  利用数组特点
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        int value = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == value) {
                count++;
            } else if (nums[i] != value && count == 1) {
                value = nums[i];
            } else {
                count--;
            }
        }


        if (!checkMoreThanHalf(value, nums)) {
            return -1;
        }
        return value;
    }

    public boolean checkMoreThanHalf(int value, int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num == value) {
                count++;
            }
        }
        if (count <= nums.length / 2) {
            return false;
        }
        return true;
    }

    //Booyer-Moore投票算法
    public int majorityElement2(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

}
