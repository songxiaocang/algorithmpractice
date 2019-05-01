package util;

/**
 * @Author: Songxc
 * @Date: 1:35 2019/4/30
 * @Description:
 */
public class Node<T> {
    public  T val;
    public Node left,right;

    public Node(T val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

}
