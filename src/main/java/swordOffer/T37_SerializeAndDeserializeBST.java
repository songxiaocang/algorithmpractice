package swordOffer;

import util.TreeNode;

/**
 * @Author: Songxc
 * @Date: 10:29 2019/6/2
 * @Description:  二叉树的序列化与反序列化
 *  思路：
 *   序列化为前序遍历序列
 *   根据前序遍历序列反序列化出二叉树
 *   如果期望边序列化数据，边反序列化二叉树，仅可以使用前序遍历或者层序遍历，但层序遍历的空节点的数目较多，不建议采用。
 */
public class T37_SerializeAndDeserializeBST {
    public static String serialize(TreeNode<Integer> root){
        if (root == null){
            return "$,";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val+",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }

    public static TreeNode<Integer> deserialize(String str){
        StringBuilder sb = new StringBuilder(str);
        return deserialize(sb);
    }

    public static TreeNode<Integer> deserialize(StringBuilder sb){
        if (sb.length() == 0){
            return null;
        }
        String val = sb.substring(0, sb.indexOf(","));
        sb.delete(0, sb.indexOf(",")+1);
        if (val.equals("$")){
            return null;
        }
        TreeNode<Integer> node = new TreeNode<>(Integer.parseInt(val));
        node.left = deserialize(sb);
        node.right = deserialize(sb);
        return node;
    }

    public static void main(String[] args) {
        //            1
        //          /   \
        //         2     3
        //       /      / \
        //      4      5   6
        //    1,2,4,$,$,$,3,5,$,$,6,$,$
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.left = new TreeNode<Integer>(2);
        root.right = new TreeNode<Integer>(3);
        root.left.left = new TreeNode<Integer>(4);
        root.right.left = new TreeNode<Integer>(5);
        root.right.right = new TreeNode<Integer>(6);

        System.out.println(root);
        System.out.println(serialize(root));
        System.out.println(deserialize(serialize(root)));
    }
}
