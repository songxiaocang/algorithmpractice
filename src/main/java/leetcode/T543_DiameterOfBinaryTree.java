package leetcode;

import util.TreeNode;

/**
 * @Author: Songxc
 * @Date: 17:06 2019/9/13
 * @Description: 二叉树的直径
 *
 *  给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 *
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 *
 * 思路：
 *  递归遍历
 *   树的直径：
 *    一个节点的最大直径 = 它左树的高度 +  它右树的高度
 *
 *    其实就是遍历每个节点，找出所有节点中的直径的最大值即可。
 *    时间复杂度为0（n）， 空间复杂度为0（n）
 */
public class T543_DiameterOfBinaryTree {
    //设置一个类变量，用于记录最大直径
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode<Integer> root) {
        depth(root);
        return max;
    }

    private int depth(TreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        //max记录当前的最大直径
        max = Math.max(leftDepth + rightDepth, max);
        //由于我计算的直径是左树高度+右树高度，所以这里返回当前树的高度，以供使用
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
