package swordOffer;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Songxc
 * @Date: 0:05 2019/5/27
 * @Description:  二叉树中和为某一值的路径
 *  思路：
 *   递归解决（类似前序遍历），使用一个路径数组保存走过的路径，当从子节点向父节点返回时，需要从路径数组中删除子节点
 *
 */
public class T34_FindPath {
    public static void findPath(TreeNode<Integer> root, int expectSum){
        if(root == null){
            return;
        }
        List<Integer> path = new ArrayList<>();
        findPath(root, path, expectSum, 0);
    }

    public static void findPath(TreeNode<Integer> root, List<Integer> path, int expectSum, int curSum){
        path.add(root.val);
        curSum+=root.val;

        if(root.left!=null){
            findPath(root.left, path, expectSum, curSum);
        }
        if(root.right!=null){
            findPath(root.right, path, expectSum, curSum);
        }
        if(root.left == null && root.right == null && curSum == expectSum){
            System.out.println(path);
        }
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        //            10
        //          /   \
        //         5     12
        //       /  \
        //      4    7
        TreeNode<Integer> root = new TreeNode<Integer>(10);
        root.left = new TreeNode<Integer>(5);
        root.right = new TreeNode<Integer>(12);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(7);
        findPath(root, 22);
    }
}
