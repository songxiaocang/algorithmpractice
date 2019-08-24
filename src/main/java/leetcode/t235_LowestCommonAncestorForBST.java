package leetcode;

import util.TreeNode;

/**
 * @Author: Songxc
 * @Date: 16:08 2019/8/24
 * @Description: 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *
 *  思路:
 *   有递归和迭代两种解决方法
 *   1）递归
 *   时间复杂度：O(N)
 * 其中 N 为 BST 中节点的个数，在最坏的情况下我们可能需要访问 BST 中所有的节点。
 * 空间复杂度：O(N)
 * 所需开辟的额外空间主要是递归栈产生的，之所以是 N 是因为 BST 的高度为 N。
 *
 *   2）迭代
 *   时间复杂度：O(N)
 * 其中 N为 BST 中节点的个数，在最坏的情况下我们可能需要遍历 BST 中所有的节点。
 * 空间复杂度：O(1)

 */
public class t235_LowestCommonAncestorForBST {
    //迭代
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = (int) p.val;
        int qVal = (int) q.val;

        TreeNode node = root;
        while (node != null) {
            int parentVal = (int) node.val;

            if (parentVal > pVal && parentVal > qVal) {
                node = node.left;
            } else if (parentVal < pVal && parentVal < qVal) {
                node = node.right;
            } else {
                return node;
            }
        }

        return null;
    }

    //递归
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        // Value of current node or parent node.
        int parentVal = (int) root.val;

        // Value of p
        int pVal = (int) p.val;

        // Value of q;
        int qVal = (int) q.val;

        if (pVal > parentVal && qVal > parentVal) {
            // If both p and q are greater than parent
            return lowestCommonAncestor(root.right, p, q);
        } else if (pVal < parentVal && qVal < parentVal) {
            // If both p and q are lesser than parent
            return lowestCommonAncestor(root.left, p, q);
        } else {
            // We have found the split point, i.e. the LCA node.
            return root;
        }
    }

}
