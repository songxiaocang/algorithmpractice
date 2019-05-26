package util;

import java.util.LinkedList;
import java.util.Queue;

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

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(this);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            sb.append(node.val+",");

            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }

        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("]");
        return sb.toString();
    }
}
