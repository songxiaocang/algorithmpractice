package swordOffer;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Songxc
 * @Date: 13:07 2019/6/22
 * @Description:  二叉树的深度
 *  思路；
 *   两种解法：
 *    递归和层序遍历
 */
public class T55_TreeDepth {
    //递归
    public static int treeDepth1(TreeNode<Integer> root){
        if (root == null){
            return 0;
        }
        int left = treeDepth1(root.left);
        int right = treeDepth1(root.right);
        return left>right? (left+1) : (right+1);
    }

    //层序遍历
    public static int treeDepth2(TreeNode<Integer> root){
        if (root == null){
            return 0;
        }
        int depth = 0;
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode<Integer> cur = queue.poll();
                if (cur.left != null){
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.left.right.left = new TreeNode<>(7);
        root.right = new TreeNode<>(3);
        root.right.right = new TreeNode<>(6);
        System.out.println(treeDepth1(root));
        System.out.println(treeDepth2(root));
    }
}
