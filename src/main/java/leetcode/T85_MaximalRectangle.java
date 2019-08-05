package leetcode;

import java.util.Stack;

/**
 * @Author: Songxc
 * @Date: 23:31 2019/8/5
 * @Description: 最大矩形
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * <p>
 * 思路：
 * 该题可以看作T84-柱状图中的最大矩形的变种，可以继续使用栈实现：
 * 栈， 时间复杂度为0（mn），空间复杂度为0（m）
 * <p>
 * 还可以使用动态规划实现，原理稍复杂，不再举证，时间空间复杂度同上
 */
public class T85_MaximalRectangle {
    //栈实现
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length <= 0) {
            return 0;
        }
        int maxArea = 0;
        int[] dp = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, maxRectangleArea(dp));
        }

        return maxArea;
    }

    public int maxRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - 1 - stack.peek()));
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - 1 - stack.peek()));
        }
        return maxArea;
    }
}
