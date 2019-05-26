package swordOffer;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Songxc
 * @Date: 20:42 2019/5/26
 * @Description: 从上到下打印二叉树
 *  思路：
 *   层序遍历，可以使用链表实现。
 */
public class T32_PrintBinaryTreeFromTopToBottom {
    //链表
    public static void printBinaryTree(TreeNode<Integer> root){
        if(root == null){
            return;
        }
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode<Integer> node = queue.poll();
            System.out.print(node.val + " ");

            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }

        }

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

        printBinaryTree(root);
    }
}
