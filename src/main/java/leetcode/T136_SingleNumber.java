package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Songxc
 * @Date: 18:51 2019/8/11
 * @Description: 只出现一次的数字
 *  给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 *
 *  思路：
 *   有哈希表 和 异或两种方法，建议采用异或
 *   1）哈希表 时间复杂度0(n)  空间复杂度0(n)
 *   2）异或 时间复杂度0(n)  空间复杂度0(1)
 *
 */
public class T136_SingleNumber {
    //异或
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }

    //哈希表
    public int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            Integer count = map.get(i);
            count = count == null ? 1 : ++count;
            map.put(i, count);
        }
        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count == 1) {
                return i;
            }
        }
        return -1; // can't find it.
    }
}
