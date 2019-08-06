package leetcode;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Songxc
 * @Date: 1:30 2019/8/7
 * @Description: 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * <p>
 * 思路：
 * 有 递归 和循环两种实现方式
 * 1）递归  时间复杂度为0（n），空间复杂度为0（n）
 * 递归调用的次数受树的高度限制。在最糟糕情况下，树是线性的，其高度为 O(n)O(n)O(n)。因此，在最糟糕的情况下，由栈上的递归调用造成的空间复杂度为 O(n)O(n)O(n)。
 * <p>
 * 2）循环  时间复杂度为0（n），空间复杂度为0（n）
 */
public class T101_IsSymmetric {
    //循环 队列 中序遍历
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();

            if (n1 == null && n2 == null) {
                continue;
            }

            if (n1 == null || n2 == null) {
                return false;
            }
            if (n1.val != n2.val) {
                return false;
            }

            queue.offer(n1.left);
            queue.offer(n2.right);
            queue.offer(n1.right);
            queue.offer(n2.left);
        }

        return true;
    }

    //递归
    public boolean isSymmetric2(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }


}
