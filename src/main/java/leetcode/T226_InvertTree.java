package leetcode;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Songxc
 * @Date: 0:03 2019/8/21
 * @Description: 翻转二叉树
 *  翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 *
 *  思路；
 *   有两种解决办法：递归和迭代（BFS）
 *   1） 递归
 *    既然树中的每个节点都只被访问一次，那么时间复杂度就是 O(n)，其中 n 是树中节点的个数。在反转之前，不论怎样我们至少都得访问每个节点至少一次，因此这个问题无法做地比 O(n)更好了。
 *    本方法使用了递归，在最坏情况下栈内需要存放 O(h) 个方法调用，其中 hhh 是树的高度。由于 h∈O(n)，可得出空间复杂度为 O(n)。
 *
 *  2）迭代 （BFS: 广度优先遍历）
 *  这个方法的思路就是，我们需要交换树中所有节点的左孩子和右孩子。因此可以创一个队列来存储所有左孩子和右孩子还没有被交换过的节点。开始的时候，只有根节点在这个队列里面。
 *  只要这个队列不空，就一直从队列中出队节点，然后互换这个节点的左右孩子节点，接着再把孩子节点入队到队列，对于其中的空节点不需要加入队列。最终队列一定会空，这时候所有节点的孩子节点都被互换过了，直接返回最初的根节点就可以了。
 *
 *  既然树中的每个节点都只被访问/入队一次，时间复杂度就是 O(n)，其中 n 是树中节点的个数。
 *
 * 空间复杂度是 O(n)，即使在最坏的情况下，也就是队列里包含了树中所有的节点。对于一颗完整二叉树来说，叶子节点那一层拥有 ⌈n/2⌉=O(n)个节点。
 *
 *
 */
public class T226_InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }


    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }

}
