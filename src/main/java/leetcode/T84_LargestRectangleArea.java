package leetcode;

import java.util.Stack;

/**
 * @Author: Songxc
 * @Date: 1:07 2019/8/5
 * @Description: 柱状图中的最大矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 示例:
 * <p>
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * <p>
 * 思路：
 * 分治法  时间复杂度为0（nlogn），空间复杂度为0（n）
 * 栈  时间复杂度为0（n），空间复杂度为0（n）
 */
public class T84_LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length <= 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - 1 - stack.peek()));
        }

        return maxArea;
    }
}
