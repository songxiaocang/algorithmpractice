package swordOffer;

import util.TreeNode;

/**
 * @Author: Songxc
 * @Date: 14:37 2019/5/25
 * @Description:  输入两个二叉树，判断A是不是B的子结构
 *  思路：
 *      从根节点一次往下匹配，需要用到递归
 */
public class T26_HasSubTreeInTree {
    public static boolean hasSubTree(TreeNode<Integer> root1, TreeNode<Integer> root2){
        if(root2 == null){
            return true;
        }
        if (root1 == null){
            return false;
        }

        if (root1.val.equals(root2.val)){
            if(hasSubTreeFromRoot(root1, root2)){
                return true;
            }
        }

        return hasSubTree(root1.left, root2) || hasSubTree(root1.right, root2);
    }

    public static boolean hasSubTreeFromRoot(TreeNode<Integer> root1, TreeNode<Integer> root2){
        if (root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }

        if(root1.val.equals(root2.val) && hasSubTreeFromRoot(root1.left, root2.left) && hasSubTreeFromRoot(root1.right, root2.right)){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        /**    tree1          tree2          tree3
         *      8               8              2
         *     /\              /\             /\
         *    8  7            9 2            4 3
         *   /\  /\
         *  9 2  4 7
         */
        TreeNode<Integer> root1 = new TreeNode<>(8);
        root1.left = new TreeNode<>(8);
        root1.right = new TreeNode<>(7);
        root1.left.left = new TreeNode<>(9);
        root1.left.right = new TreeNode<>(2);
        root1.left.right.left = new TreeNode<>(4);
        root1.left.right.right = new TreeNode<>(7);
        TreeNode<Integer> root2 = new TreeNode<>(8);
        root2.left = new TreeNode<>(9);
        root2.right = new TreeNode<>(2);
        TreeNode<Integer> root3 = new TreeNode<>(2);
        root3.left = new TreeNode<>(4);
        root3.right = new TreeNode<>(3);

        System.out.println(hasSubTree(root1, root2)); //true
        System.out.println(hasSubTree(root1, root3));  //false



    }

}
