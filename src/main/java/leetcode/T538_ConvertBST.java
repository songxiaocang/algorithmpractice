package leetcode;

import util.TreeNode;

/**
 * @Author: Songxc
 * @Date: 16:49 2019/9/13
 * @Description: 把二叉树转换成累加树
 *  给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 例如：
 *
 * 输入: 二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 *
 * 思路：
 *  逆中序遍历
 *   时间复杂度为0（n）， 空间复杂度0（n）  （递归调用所产生的的空间开销）
 *
 */
public class T538_ConvertBST {
    public TreeNode convertBST(TreeNode<Integer> root) {
        if (root != null) {
            dfs(root, 0);
        }
        return root;
    }

    public int dfs(TreeNode<Integer> node, int sum) {
        if (node == null) {
            return sum;
        }
        sum = dfs(node.right, sum);
        int nodeVal = node.val;
        node.val += sum;
        sum += nodeVal;
        sum = dfs(node.left, sum);
        return sum;
    }
}
