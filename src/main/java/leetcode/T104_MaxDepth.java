package leetcode;

import javafx.util.Pair;
import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Songxc
 * @Date: 10:44 2019/8/10
 * @Description: 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 返回它的最大深度 3 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * <p>
 * 思路：
 * 有两种方法：
 * 1） 递归  时间复杂度：0（N），空间复杂度为0（N） - 0（logN）
 * 空间复杂度：在最糟糕的情况下，树是完全不平衡的，例如每个结点只剩下左子结点，递归将会被调用 NNN 次（树的高度），因此保持调用栈的存储将是 O(N)O(N)O(N)。但在最好的情况下（树是完全平衡的），树的高度将是 log⁡(N)\log(N)log(N)。因此，在这种情况下的空间复杂度将是 O(log⁡(N))O(\log(N))O(log(N))。
 * <p>
 * 2） 迭代（层序遍历）
 * 时间复杂度为0（n），空间复杂度为0（n）
 */
public class T104_MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int depth = 0;
        queue.offer(new Pair(root, 1));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode cur = pair.getKey();
            int curDepth = pair.getValue();
            if (cur != null) {
                depth = Math.max(depth, curDepth);
                queue.offer(new Pair(cur.left, curDepth + 1));
                queue.offer(new Pair(cur.right, curDepth + 1));
            }
        }

        return depth;

    }

}
