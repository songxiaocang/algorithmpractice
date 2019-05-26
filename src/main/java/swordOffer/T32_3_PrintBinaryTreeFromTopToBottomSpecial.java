package swordOffer;

import util.TreeNode;

import java.util.Stack;

/**
 * @Author: Songxc
 * @Date: 21:22 2019/5/26
 * @Description:  之字形打印二叉树
 *  思路：
 *   利用双栈实现
 */
public class T32_3_PrintBinaryTreeFromTopToBottomSpecial {
    public static void printBinaryTree(TreeNode<Integer> root){
        if(root == null){
            return;
        }
        Stack<TreeNode<Integer>> stack1 = new Stack<>();
        Stack<TreeNode<Integer>> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            if(!stack1.isEmpty()){
                while(!stack1.isEmpty()){
                    TreeNode<Integer> node = stack1.pop();
                    System.out.print(node.val+" ");

                    if(node.left != null){
                        stack2.push(node.left);
                    }
                    if(node.right != null){
                        stack2.push(node.right);
                    }
                }
            }

            System.out.println();

            if(!stack2.isEmpty()){
                while(!stack2.isEmpty()){
                    TreeNode<Integer> node = stack2.pop();
                    System.out.print(node.val+" ");

                    if(node.right != null){
                        stack1.push(node.right);
                    }
                    if(node.left != null){
                        stack1.push(node.left);
                    }

                }
            }

            System.out.println();
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
