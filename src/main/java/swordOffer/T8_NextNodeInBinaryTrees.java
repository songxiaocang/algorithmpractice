package swordOffer;

import util.TreeNode;

/**
 * @Author: Songxc
 * @Date: 0:49 2019/5/2
 * @Description:
 *  给定二叉树和其中一个节点，找到中序遍历序列的下一个节点。树中的节点除了有左右孩子指针，还有一个指向父节点的指针。
 *  思路：
 *  （1）如果输入的当前节点有右孩子，则它的下一个节点即为该右孩子为根节点的子树的最左边的节点，比如2->5,1->3
 * （2）如果输入的当前节点没有右孩子，就需要判断其与自身父节点的关系：
 * （2.1）如果当前节点没有父节点，那所求的下一个节点不存在，返回null.
 * （2.2）如果输入节点是他父节点的左孩子，那他的父节点就是所求的下一个节点,比如4->2
 * （2.3）如果输入节点是他父节点的右孩子，那就需要将输入节点的父节点作为新的当前节点，返回到（2）,判断新的当前节点与他自身父节点的关系,比如5->1
 *
 */
public class T8_NextNodeInBinaryTrees {
    public static TreeNode nextNode(TreeNode node){
        if (node == null){
            return null;
        }else if(node.right!=null){
            node = node.right;
            while (node.left != null){
                node = node.left;
            }
            return node;
        }

        while(node.father != null){
            if (node == node.father.left){
                return node.father;
            }
            node = node.father;
        }

        return null;
    }

    public static void main(String[] args) {
        /**
         *       1
         *      /\
         *    2   3
         *   /\
         *  4 5
         *  inorder:  42513
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.father= root;
        root.right = new TreeNode(3);
        root.right.father = root;
        root.left.left = new TreeNode(4);
        root.left.left.father = root.left;
        root.left.right = new TreeNode(5);
        root.left.right.father = root.left;

        System.out.println(nextNode(root) == null?  null:nextNode(root).val);
        System.out.println(nextNode(root.left) == null?  null:nextNode(root.left).val);
        System.out.println(nextNode(root.right) ==  null?  null:nextNode(root.right).val );
        System.out.println(nextNode(root.left.left) == null?  null:nextNode(root.left.left).val);
        System.out.println(nextNode(root.left.right) == null? null:nextNode(root.left.right).val);
    }

}
