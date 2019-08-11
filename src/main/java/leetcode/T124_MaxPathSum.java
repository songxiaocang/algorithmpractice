package leetcode;

import util.TreeNode;

/**
 * @Author: Songxc
 * @Date: 14:26 2019/8/11
 * @Description: 二叉树中的最大路径和
 *
 *  给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 *
 * 思路：
 *  递归实现
 *   使用一个中间变量记录每次遍历节点所在的路径之和的最大值，直到遍历结束。
 *
 *   时间复杂度为：0（n）
 *   空间复杂度为0(log(n))， 需要一个大小与树高度相等的栈开销，对于二叉树空间开销是0（logN）
 */
public class T124_MaxPathSum {
    private int sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return sum;
    }

    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftSum = Math.max(maxGain(node.left), 0);
        int rightSum = Math.max(maxGain(node.right), 0);

        int newSum = (int) node.val + leftSum + rightSum;

        sum = Math.max(sum, newSum);

        return (int) node.val + Math.max(leftSum, rightSum);
    }
}
