package swordOffer;

import util.TreeNode;

/**
 * @Author: Songxc
 * @Date: 20:00 2019/6/1
 * @Description: 二叉搜索树转换为有序双向链表
 *  思路：
 *   中序遍历左右子树，并将其转化为有序链表，最后将他们与根节点相连即可。
 */
public class T36_BSTConvertToTwoWayLinkedList {
    public static TreeNode<Integer> convert(TreeNode<Integer> root){
        if (root == null){
            return root;
        }
        TreeNode<Integer>[] result = convertNode(root);
        return result[0];
    }

    public static TreeNode<Integer>[] convertNode(TreeNode<Integer> node){
        TreeNode<Integer>[] result = new TreeNode[2];
        if (node.left == null && node.right == null){
            result[0] = node;
            result[1] = node;
        }else if(node.right == null){
            result = convertNode(node.left);
            node.left = result[1];
            result[1].right = node;
            result[1] = node;
        }else if(node.left == null){
            result = convertNode(node.right);
            node.right = result[0];
            result[0].left = node;
            result[0] = node;
        }else{
            TreeNode<Integer>[] resLeft = convertNode(node.left);
            TreeNode<Integer>[] resRight = convertNode(node.right);
            node.left = resLeft[1];
            resLeft[1].right = node;
            node.right = resRight[0];
            resRight[0].left = node;
            result[0] = resLeft[0];
            result[1] = resRight[1];
        }
        return result;
    }

    public static void main(String[] args) {
        //            10
        //          /   \
        //         6     14
        //       /  \   / \
        //      4    8 12  16
        TreeNode<Integer> root = new TreeNode<Integer>(10);
        root.left = new TreeNode<Integer>(6);
        root.right = new TreeNode<Integer>(14);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(8);
        root.right.left = new TreeNode<Integer>(12);
        root.right.right = new TreeNode<Integer>(16);

        TreeNode<Integer> head = convert(root);

        System.out.println(print(head));

    }

    public static String print(TreeNode node){
        TreeNode cur = node;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(cur != null){
            sb.append(cur.val);
            if (cur.right != null){
                sb.append(",");
            }
            cur = cur.right;
        }
        sb.append("]");
        return sb.toString();
    }
}
