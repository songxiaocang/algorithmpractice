package swordOffer;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Songxc
 * @Date: 12:50 2019/5/26
 * @Description:  判断一个二叉树是不是对称树
 * 思路：
 *  有递归和循环两种实现方式
 *  递归：比较他的前序遍历和对称前序遍历（中右左）
 *  循环：需要用到层序遍历
 */
public class T28_IsSymmetricalForBT {

    //递归方式实现
    public static boolean isSymmetrical(TreeNode<Integer> root){
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        if(root.left == null || root.right == null){
            return true;
        }
        return isSymmetrical(root, root);
    }


    public static boolean isSymmetrical(TreeNode<Integer> root1, TreeNode<Integer> root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return true;
        }
        if(!root1.val.equals(root2.val)){
            return false;
        }
        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);

    }

    //循环方式实现
    public static boolean isSymmetricalNotRecuisively(TreeNode<Integer> root){
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        if(root.left == null || root.right == null){
            return false;
        }

        Queue<TreeNode<Integer>> queueLeft = new LinkedList<>();
        Queue<TreeNode<Integer>> queueRight = new LinkedList<>();
        queueLeft.offer(root);
        queueRight.offer(root);
        while(!queueLeft.isEmpty() || !queueRight.isEmpty()){
            TreeNode<Integer> nodeLeft = queueLeft.poll();
            TreeNode<Integer> nodeRight = queueRight.poll();

            if(nodeLeft.val.equals(nodeRight.val)){
                if(nodeLeft.left != null){
                    queueLeft.offer(nodeLeft.left);
                }
                if(nodeLeft.right != null){
                    queueLeft.offer(nodeLeft.right);
                }
                if(nodeRight.right != null){
                    queueRight.offer(nodeRight.right);
                }
                if(nodeRight.left != null){
                    queueRight.offer(nodeRight.left);
                }
            }else{
                return false;
            }
        }
        if(queueLeft.isEmpty() && queueRight.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        /**
         *       8
         *      /\
         *    4   4
         *   /\  /\
         *  1 5 5 1
         */
        TreeNode<Integer> root = new TreeNode<>(8);
        root.left = new TreeNode<>(4);
        root.right = new TreeNode<>(4);
        root.left.left = new TreeNode<>(1);
        root.left.right = new TreeNode<>(5);
        root.right.left = new TreeNode<>(5);
        root.right.right = new TreeNode<>(5);
        System.out.println(isSymmetrical(root));

        System.out.println(isSymmetricalNotRecuisively(root));
    }
}
