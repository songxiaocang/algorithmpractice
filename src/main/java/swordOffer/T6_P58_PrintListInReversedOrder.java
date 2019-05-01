package swordOffer;

import java.util.Stack;

/**
 * @Author: Songxc
 * @Date: 1:27 2019/4/26
 * @Description: 从尾到头打印链表
 */
public class T6_P58_PrintListInReversedOrder {
     public static class ListNode<T>{
         private T val;
         private ListNode<T> next;

         public ListNode(T val){
             this.val = val;
         }

         public T getVal(){
             return val;
         }

         public void setVal(T val){
             this.val = val;
         }

         public ListNode<T> getNext(){
             return next;
         }

         public void setNext(ListNode<T> next){
             this.next = next;
         }

         @Override
         public String toString(){
             StringBuilder sb = new StringBuilder();
             sb.append("[");
             for(ListNode<T> cur = this; cur!=null; cur = cur.next){
                 sb.append(cur.val);
                 if (cur.next != null){
                     sb.append(", ");
                 }
             }
             sb.append("]");
             return sb.toString();
         }
     }


     public static void printReversingRecursively(ListNode<Integer> node){
         if (node == null ) return;
         printReversingRecursively(node.next);
         System.out.print(node.val +" ");
     }

     public static void printReversingIterately(ListNode<Integer> node){
         Stack<Integer> stack = new Stack<>();
         for (ListNode<Integer> cur = node; cur!=null; cur= cur.next){
             stack.add(cur.val);
         }

         while(!stack.isEmpty()){
             Object val = stack.pop();
             System.out.print(val + " ");
         }
     }

    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<Integer>(1);
        head.next = new ListNode<Integer>(3);
        head.next.next = new ListNode<Integer>(2);
        System.out.println("递归版：");
        printReversingRecursively(head);
        System.out.println(" ");
        System.out.println("非递归版：");
        printReversingIterately(head);
        System.out.println("");
        System.out.println("当前链表："+head.toString());
    }
}
