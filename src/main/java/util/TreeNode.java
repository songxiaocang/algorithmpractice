package util;

/**
 * @Author: Songxc
 * @Date: 0:50 2019/5/2
 * @Description:
 */
public class TreeNode<T> {
    public T val;
    public TreeNode left,right,father;

    public TreeNode(T val){
        this.val = val;
        this.left = null;
        this.right = null;
        this.father = null;
    }
}
