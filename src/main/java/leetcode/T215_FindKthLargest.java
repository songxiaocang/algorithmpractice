package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: Songxc
 * @Date: 0:54 2019/8/19
 * @Description: 数组中的第K大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 *
 * 思路：
 * 两种解法，小顶堆 ， 快速选择排序
 * 1） 小顶堆
 *  时间复杂度 : O(Nlogk)。
 * 空间复杂度 : O(k)，用于存储堆元素。
 *
 * 2） 快速选择算法
 *  该算法较复杂，暂不贴出
 *  可以参靠解答
 *   https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode/
 *
 * 时间复杂度 : 平均情况 O(N)，最坏情况 O(N2)。
 * 空间复杂度 : O(1)。
 *
 */
public class T215_FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length <= 0 || k <= 0) {
            return -1;
        }

        Queue<Integer> queue = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.poll();
    }
}
