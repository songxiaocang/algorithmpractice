package swordOffer;

import java.util.*;

/**
 * @Author: Songxc
 * @Date: 0:54 2019/4/28
 * @Description: 二叉树 先序、中序、后序遍历（递归与非递归版本），层次遍历
 *  二叉树 查询某个
 */
public class T6_2_TravesalOfBinaryTree<E extends Comparable<E>>{
    public static class Node<E>{
        public E val;
        public Node left,right;

        public Node(E val){
            this.val = val;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public T6_2_TravesalOfBinaryTree(){
        root = null;
        size = 0;
    }

    public boolean contains(E e){
        return contains(root,e);
    }

    public boolean contains(Node node,E e){
        if(node == null){
            return false;
        }

        if (e.compareTo((E) node.val) == 0){
            return true;
        }
        if (e.compareTo((E)node.val)<0){
            return contains(node.left,e);
        }else{
            return contains(node.right,e);
        }
    }

    /**
     *
     * @param e
     * @return 返回当前元素的根
     */
    public Node add(E e){
       return add(root,e);
    }
    public Node add(Node node,E e){
        if (node == null){
            size ++;
            return new Node(e);
        }

        if(e.compareTo((E)node.val)<0){
            node.left = add(node.left, e);
        }
        if (e.compareTo((E)node.val)>0){
            node.right = add(node.right,e);
        }
        return node;
    }

    /**
     * 先根遍历
     */
    public static void preOrder(Node node){
        if (node == null){
            return;
        }

        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中根遍历
     * @param node
     */
    public static void inOrder(Node node){
        if (node == null){
            return;
        }

        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }

    /**
     * 后根遍历
     * @param node
     */
    public static void postOrder(Node node){
        if (node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val);
    }

    /**
     * 先根遍历 递归
     * @return
     */
    public List<E> preOrderRecursively(){
        List<E> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        Node cur = root;
        while(cur !=null || !stack.isEmpty()) {
            while (cur != null) {
                list.add((E) cur.val);
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            cur = cur.right;
        }

        return list;
    }

    /**
     * 中根遍历 非递归
     * @return
     */
    public List<E> inOrderRecursively(){
        List<E> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        Node cur = root;
        while(cur !=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            list.add((E)cur.val);
            cur = cur.right;
        }

        return list;
    }

    /**
     * 后根遍历 非递归
     * @return
     */
    public void postOrderRecursively(){
        List<E> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Stack<Node> output = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            output.push(cur);

            if (cur.left!=null){
                stack.push(cur.left);
            }
            if (cur.right!=null){
                stack.push(cur.right);
            }
        }

        while(!output.isEmpty()){
            System.out.println(output.pop().val);
        }
    }

    /**
     * 层序遍历
     */
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.println(node.val);

            if (node.left !=null){
                queue.add(node.left);
            }

            if (node.right !=null){
                queue.add(node.right);
            }
        }

    }

    public static void main(String[] args){
        Node<Integer> root = new Node<Integer>(1);
        root.left = new Node<Integer>(3);
        root.right = new Node<Integer>(2);



        System.out.println("先根遍历：");
        preOrder(root);
        System.out.println("中根遍历：");
        inOrder(root);
        System.out.println("后根遍历：");
        postOrder(root);

        T6_2_TravesalOfBinaryTree travesal = new T6_2_TravesalOfBinaryTree();
        travesal.root = root;
        System.out.println("先根非递归遍历：");
        List list = travesal.preOrderRecursively();
        System.out.println(list);

        System.out.println("中跟非递归遍历：");
        List list2 = travesal.inOrderRecursively();
        System.out.println(list2);

        System.out.println("后根非递归遍历：");
        travesal.postOrderRecursively();

        System.out.println("层序遍历：");
        travesal.levelOrder();
    }

}
