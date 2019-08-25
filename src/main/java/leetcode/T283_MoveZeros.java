package leetcode;

/**
 * @Author: Songxc
 * @Date: 14:40 2019/8/25
 * @Description: 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 说明:
 *
 *     必须在原数组上操作，不能拷贝额外的数组。
 *     尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 *
 *
 * 思路：
 *  主要介绍两种方法
 *  1） 非零元素向前移动，零元素往原数组尾部追加（使用中间变量记录0元素个数）
 *  时间复杂度：O(n)。但是，操作仍然是局部优化的。代码执行的总操作（数组写入）为 n（元素总数）。
 * 空间复杂度：O(1)，只使用常量空间。
 *
 *  2）交换0与非0元素位置 （使用中间变量lastNonZeroIndex记录最左0元素位置）
 *  时间复杂度：O(n)。但是，操作是最优的。代码执行的总操作（数组写入）是非 0 元素的数量。这比上一个解决方案的复杂性（当大多数元素为 0 时）要好得多。但是，两种算法的最坏情况（当所有元素都为非 0 时）复杂性是相同的。
 * 空间复杂度：O(1)，只使用了常量空间。
 *
 */
public class T283_MoveZeros {
    public void moveZeroes(int[] nums) {
        int lastNonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[lastNonZeroIndex];
                nums[lastNonZeroIndex] = nums[i];
                nums[i] = temp;
                lastNonZeroIndex++;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int lastNonZeroFoundAt = 0;
        // If the current element is not 0, then we need to
        // append it just in front of last non 0 element we found.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }
        // After we have finished processing new elements,
        // all the non-zero elements are already at beginning of array.
        // We just need to fill remaining array with 0's.
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


}
