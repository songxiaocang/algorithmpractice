package swordOffer;

import util.TreeNode;

/**
 * @Author: Songxc
 * @Date: 13:55 2019/6/23
 * @Description: 二叉树的深度
 *  思路：
 *   使用递归后序遍历，切勿使用值传递
 */
public class T55_2_IsBalanced {
    public static boolean isBalanced(TreeNode<Integer> root) {
        if (root == null) {
            return true;
        }
        int[] depth ={0};
        return isBalanced(root, depth);
    }

    public static boolean isBalanced(TreeNode<Integer> root, int[] depth) {
        if (root == null) {
            depth[0] = 0;
            return true;
        }
        int[] left={0}, right={0};
        if (isBalanced(root.left, left) && isBalanced(root.right, right)) {
            int diff = left[0] - right[0];
            if (diff <= 1 && diff >= -1) {
                depth[0] = left[0] > right[0] ? left[0] + 1 : right[0] + 1;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.left.right.left = new TreeNode<>(7);
        root.right = new TreeNode<>(3);
//        root.right.right = new TreeNode<>(6);
        System.out.println(isBalanced(root));
    }
}
