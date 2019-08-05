package leetcode;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Songxc
 * @Date: 0:40 2019/8/6
 * @Description: 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * <p>
 * <p>
 * 思路；
 * 1）递归   时间复杂度为：O(n)。递归函数 T(n)=2⋅T(n/2)+1 ； 空间复杂度为：最坏情况下需要空间 0(n) 平均情况为(logn)。
 * 2) 非递归  时间复杂度为0（n）， 空间复杂度为0（n）
 */
public class T94_InOrderTraversal {
    private List<Integer> list = new ArrayList<>();

    //递归版本
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        inorderTraversal(root.left);
        list.add((Integer) root.val);
        inorderTraversal(root.right);
        return list;
    }

    //非递归版本
    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            list.add((Integer) cur.val);
            cur = cur.right;
        }
        return list;
    }
}
