package swordOffer;

/**
 * @Author: Songxc
 * @Date: 22:49 2019/5/26
 * @Description:  二叉搜索树的后续遍历
 *  输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果，假设输入数组的任意两个数都互不相同。
 *   思路：
 *   根据二叉搜索树的性质，递归判断左右子树是否满足二叉搜索树的特点
 */
public class T33_VerifyBinaryTree {
    public static boolean verifyBinaryTree(int[] data){
        if (data == null || data.length<=0){
            return false;
        }
        if(data.length <=2){
            return true;
        }
        return verifyBinaryTree(data, 0, data.length-1);
    }
    public static boolean verifyBinaryTree(int[] data, int start, int end){
        if(end - start <= 1){
            return true;
        }

        int temp = data[end];
        int rightIndex = 0;
        for (int i=start;i<end;i++){
            if(data[i]>temp){
                rightIndex = i;
                break;
            }
        }

        for(int j=rightIndex;j<end;j++){
            if(data[j]<=temp){
                return false;
            }
        }

        return verifyBinaryTree(data, start, rightIndex-1) && verifyBinaryTree(data, rightIndex, end-1);
    }

    public static void main(String[] args) {
        //            8
        //          /   \
        //         6     10
        //       /  \   / \
        //      5    7 9   11
        int[] data = {5,7,6,9,4,10,8};
        int[] data1 = {5,7,6,9,11,10,8};
        int[] data2 = {8,8,8,8,8,8,8};
        System.out.println(verifyBinaryTree(data));  //false
        System.out.println(verifyBinaryTree(data1));  //true
        System.out.println(verifyBinaryTree(data2, 0, data2.length-1));  //false
    }
}
