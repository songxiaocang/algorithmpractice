package swordOffer;

import util.TreeNode;

/**
 * @Author: Songxc
 * @Date: 10:45 2019/5/26
 * @Description:  二叉树的镜像
 *  思路：
 *   递归
 *   依次交换当前节点的左右子节点
 */
public class T27_BinaryTreeMirror {
    public static void mirrorRecursively(TreeNode<Integer> root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }

        TreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorRecursively(root.left);
        mirrorRecursively(root.right);
    }

    public static void main(String[] args) {
        /**
         *       8
         *      /\
         *    2   4
         *   /\  /\
         *  1 5 6 9
         */
        TreeNode<Integer> root = new TreeNode<>(8);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(4);
        root.left.left = new TreeNode<>(1);
        root.left.right = new TreeNode<>(5);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(9);
        System.out.println(root);
        mirrorRecursively(root);
        System.out.println(root);
    }
}
