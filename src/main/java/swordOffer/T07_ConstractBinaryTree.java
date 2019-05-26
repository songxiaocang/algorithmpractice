package swordOffer;

import util.Node;

/**
 * @Author: Songxc
 * @Date: 1:35 2019/4/30
 * @Description:
 */
public class T07_ConstractBinaryTree {

    public static Node construct(int[] preOrder,int[] inOrder){
        if (preOrder == null || inOrder == null || preOrder.length == 0 || inOrder.length == 0){
            return null;
        }
        return constructCore(preOrder, 0, inOrder, 0, preOrder.length);
    }


    public static Node constructCore(int[] preOrder, int preOrderStart, int[] inOrder, int inOrderStart, int length){
        if (length == 0){
            return null;
        }

        int inOrderIndex = -1;

        for (int i = inOrderStart;i<inOrderStart+length;i++){
            if (inOrder[i] == preOrder[preOrderStart]){
                inOrderIndex = i;
                break;
            }
        }

        int leftLength = inOrderIndex - inOrderStart;
        Node node = new Node(preOrder[preOrderStart]);

        node.left = constructCore(preOrder,preOrderStart+1, inOrder, inOrderStart,leftLength);
        node.right = constructCore(preOrder, preOrderStart+leftLength+1, inOrder, inOrderIndex+1, length-leftLength-1);
        return node;
    }


    public static void main(String[] args) {
        /**
         *       1
         *      /\
         *     2  3
         *    /\
         *   4  5
         *
         *   后跟：45231
         *
         */
        int[] preOrder = {1,2,4,5,3};
        int[] inOrder = {4,2,5,1,3};

        Node node = construct(preOrder,inOrder);
        System.out.println("后根遍历为：");
        postOrder(node);
    }

    public static void postOrder(Node node){
        if (node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val+" ");
    }

}
