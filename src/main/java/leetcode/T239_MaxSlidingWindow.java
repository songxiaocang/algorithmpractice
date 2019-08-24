package leetcode;

import java.util.ArrayDeque;

/**
 * @Author: Songxc
 * @Date: 19:36 2019/8/24
 * @Description: 滑动窗口最大值
 *  给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 * 示例：
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 *
 * 思路：
 *  有两种解法 1）双端队列 2）动态规划
 *  1）双端队列
 *   在滑动窗口移动过程中，使用双端队列的头部记录窗口元素的最大值，在移动的过程中，将该值写入到输出数组中
 *   时间复杂度：O(N)，每个元素被处理两次- 其索引被添加到双向队列中和被双向队列删除。
 *  空间复杂度：O(N)，输出数组使用了 O(N−k+1) 空间，双向队列使用了 O(k)。
 *
 *  2）动态规划
 *  本算法的优点是不需要使用 数组 / 列表 之外的任何数据结构。
 *  算法的思想是将输入数组分割成有 k 个元素的块。
 * 若 n % k != 0，则最后一块的元素个数可能更少。
 * 使用两个数组left ,right 记录 右区块中或者左区块中 到该元素结尾的最大元素，而滑动窗口最大值即为right[i],left[i+k-1]两者最大值
 *
 * 时间复杂度：O(N)，我们对长度为 N 的数组处理了 3次。
 *
 * 空间复杂度：O(N)，用于存储长度为 N 的 left 和 right 数组，以及长度为 N - k + 1的输出数组。
 *
 *
 */
public class T239_MaxSlidingWindow {
    //双端队列
    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int[] nums;

    public void clean_deque(int i, int k) {
        // remove indexes of elements not from sliding window
        if (!deq.isEmpty() && deq.getFirst() == i - k)
            deq.removeFirst();

        // remove from deq indexes of all elements
        // which are smaller than current element nums[i]
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])
            deq.removeLast();
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        // init deque and output
        this.nums = nums;
        int max_idx = 0;
        for (int i = 0; i < k; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            // compute max in nums[:k]
            if (nums[i] > nums[max_idx]) max_idx = i;
        }
        int[] output = new int[n - k + 1];
        output[0] = nums[max_idx];

        // build output
        for (int i = k; i < n; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        return output;
    }

    //动态规划
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            // from left to right
            if (i % k == 0) left[i] = nums[i];  // block_start
            else left[i] = Math.max(left[i - 1], nums[i]);

            // from right to left
            int j = n - i - 1;
            if ((j + 1) % k == 0) right[j] = nums[j];  // block_end
            else right[j] = Math.max(right[j + 1], nums[j]);
        }

        int[] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++)
            output[i] = Math.max(left[i + k - 1], right[i]);

        return output;
    }

}
