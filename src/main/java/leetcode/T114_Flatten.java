package leetcode;

import util.TreeNode;

import java.util.Stack;

/**
 * @Author: Songxc
 * @Date: 15:08 2019/8/10
 * @Description: 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为链表。
 * <p>
 * 例如，给定二叉树
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * <p>
 * 将其展开为：
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * <p>
 * 思路：
 * 此题注意对比sort - T36二叉树转换为双向链表
 * 有后序遍历（递归与迭代）、先序遍历三种方法
 * 此题需要用到一个中间变量 prev
 */
public class T114_Flatten {
    //后序遍历  递归实现
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    //后续遍历 迭代版 使用栈实现
    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                //递归添加右节点
                cur = cur.right;
            }

            cur = stack.peek();
            // 在不存在左节点或者右节点已经访问过的情况下，访问根节点
            if (cur.left == null || cur.left == prev) {
                cur = stack.pop();
                cur.right = prev;
                cur.left = null;
                prev = cur;
                cur = null;
            } else {
                //左节点还没有访问过就先访问左节点
                cur = cur.left;
            }
        }
    }


    //先根遍历
    public void flatten3(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        TreeNode pre = null;
        while (!s.isEmpty()) {
            TreeNode temp = s.pop();
            /***********修改的地方*************/
            if (pre != null) {
                pre.right = temp;
                pre.left = null;
            }
            /********************************/
            if (temp.right != null) {
                s.push(temp.right);
            }
            if (temp.left != null) {
                s.push(temp.left);
            }
            /***********修改的地方*************/
            pre = temp;
            /********************************/
        }
    }


}
