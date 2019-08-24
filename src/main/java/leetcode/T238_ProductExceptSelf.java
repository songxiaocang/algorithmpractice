package leetcode;

/**
 * @Author: Songxc
 * @Date: 16:44 2019/8/24
 * @Description: 除自身以外数组的乘积
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 *
 *  思路：
 *   运用前后双指针标记每个位置的左积和右积，在一次遍历中得到运算结果。
 *   时间复杂度为0（n）， 空间复杂度为0（1） （空间开销常量级别）
 */
public class T238_ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        if (nums == null || nums.length <= 0) {
            return res;
        }
        for(int i=0; i<len; i++){
            res[i] = 1;
        }

        int left = 1, right = 1;
        for (int i=0; i<len; i++) {
            res[i] *= left;
            left *= nums[i];

            res[len - i - 1] *= right;
            right *= nums[len - i - 1];
        }

        return res;
    }
}
