package leetcode;

/**
 * @Author: Songxc
 * @Date: 20:54 2019/7/28
 * @Description: 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 *  * 作者：LeetCode
 *  * 链接：https://leetcode-cn.com/problems/two-sum/solution/jie-yu-shui-by-leetcode/
 *  * 来源：力扣（LeetCode）
 *
 *
 * 思路：
 *  暴力破解法
 *  动态编程
 *  栈
 *  双指针 ：
 *   和动态编程相比，我们不从左和从右分开计算，我们想办法一次完成遍历。 从动态编程方法的示意图中我们注意到，
 *   只要 right_max[i]>left_max[i]\text{right\_max}[i]>\text{left\_max}[i]right_max[i]>left_max[i] （元素 0 到元素 6），
 *   积水高度将由 left_max 决定，类似地 left_max[i]>right_max[i]\text{left\_max}[i]>\text{right\_max}[i]left_max[i]>right_max[i]（元素 8 到元素 11）。 所以我们可以认为如果一端有更高的条形块（例如右端），积水的高度依赖于当前方向的高度（从左到右）。
 *   当我们发现另一侧（右侧）的条形块高度不是最高的，我们则开始从相反的方向遍历（从右到左）。 我们必须在遍历时维护 left_max\text{left\_max}left_max 和 right_max\text{right\_max}right_max ，但是我们现在可以使用两个指针交替进行，实现 1 次遍历即可完成。
 *

 *
 */
public class T42_Trap {
    //方法1 动态编程，使用数组保存从左到右和从右到左的最大高度，时间复杂度为0(n), 空间复杂度为O(N)
    public int trap(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int ans = 0;
        int len = height.length;
        int[] leftMax = new int[len], rightMax = new int[len];
        leftMax[0] = height[0];
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[len - 1] = height[len - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        for (int j = 0; j < len; j++) {
            ans += Math.min(leftMax[j], rightMax[j]) - height[j];
        }
        return ans;
    }


    //方法2 双指针 左右指针指代当前左右遍历的最大高度，并在遍历的过程将高度差累加到结果集ans中，时间复杂度为0(n)，空间复杂度为0(1)
    public int trap2(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int ans = 0;
        int len = height.length;
        int leftMax = 0, rightMax = 0;
        int left = 0, right = len - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    ans += (leftMax - height[left]);
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    ans += rightMax - height[right];
                }
                right--;
            }
        }
        return ans;

    }
}
