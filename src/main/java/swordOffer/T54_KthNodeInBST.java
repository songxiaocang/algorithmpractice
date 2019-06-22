package swordOffer;

import util.TreeNode;

import java.util.Stack;

/**
 * @Author: Songxc
 * @Date: 12:10 2019/6/22
 * @Description: 求二叉搜索树的第K大节点值
 *  思路:
 *   使用中序遍历，并对当前值进行计数，满足要求时即返回。
 */
public class T54_KthNodeInBST {
    public static int getKthNodeInBST(TreeNode<Integer> root, int k){
        if (root == null || k <= 0){
            return -1;
        }
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> cur = root;
        int count = 0;
        while(cur != null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }

            cur = stack.pop();
            count++;
            if (count == k){
                return cur.val;
            }
            cur = cur.right;
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(5);
        root.left = new TreeNode<>(3);
        root.left.left = new TreeNode<>(2);
        root.left.right = new TreeNode<>(4);
        root.right = new TreeNode<>(7);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(8);
        System.out.println(getKthNodeInBST(root, 3));
        System.out.println(getKthNodeInBST(root, 6));
    }
}
