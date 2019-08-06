package leetcode;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: Songxc
 * @Date: 0:19 2019/8/7
 * @Description: 验证是否二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * <p>
 * <p>
 * 思路：
 * 有递归和栈、中序遍历三种解法
 * 递归 时间复杂度0(n) 空间复杂度0（n）
 * 在每次递归的时候带入该节点的上界和下界进行比较
 * <p>
 * 栈  时间复杂度0(n) 空间复杂度0(n)
 *
 * 中序遍历 时间复杂度0(n) 空间复杂度0(n)
 */
public class T98_IsValidBST {

    //栈
    private LinkedList<TreeNode> queue = new LinkedList<>();
    private LinkedList<Integer> uppers = new LinkedList<>();
    private LinkedList<Integer> lowers = new LinkedList<>();

    public boolean isValidBST(TreeNode root) {
        Integer upper = null, lower = null, val;
        helper(root, lower, upper);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            lower = lowers.poll();
            upper = uppers.poll();

            if (cur == null) {
                continue;
            }

            val = (int) cur.val;
            if (lower != null && val <= lower) {
                return false;
            }
            if (upper != null && val >= upper) {
                return false;
            }
            helper(cur.left, lower, val);
            helper(cur.right, val, upper);
        }

        return true;
    }

    private void helper(TreeNode cur, Integer lower, Integer upper) {
        queue.offer(cur);
        lowers.offer(lower);
        uppers.offer(upper);
    }

    //递归
    private boolean helper2(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = (int) node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (!helper2(node.right, val, upper)) return false;
        if (!helper2(node.left, lower, val)) return false;
        return true;
    }

    public boolean isValidBST2(TreeNode root) {
        return helper2(root, null, null);
    }

    //中根遍历
    public boolean isValidBST3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        double inOrderVal = -Double.MAX_VALUE;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if ((int) cur.val <= inOrderVal) {
                return false;
            }
            inOrderVal = (int) cur.val;
            cur = cur.right;
        }

        return true;

    }

}
