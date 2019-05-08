package swordOffer;

import util.ListNode;

/**
 * @Author: Songxc
 * @Date: 1:30 2019/5/6
 * @Description: 删除链表中重复的元素
 * 思路：
 *  定义三个节点prev、cur、post，cur-post为重复的区域，将prev与post.next相连
 *  注意特殊情况：当被删除节点在链表头部或者尾部的时候，需要修改head或prev。
 */
public class T18_2_DeleteDuplicatedNode {
    public static ListNode<Integer> deleteDuplicatedNode(ListNode<Integer> head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode<Integer> prev = null;
        ListNode<Integer> cur = head;
        ListNode<Integer> post = cur.next;
        boolean needDelete = false;
        while(post!=null){
            if(cur.val.equals(post.val)){
                needDelete = true;
                post = post.next;
            }else if(needDelete && !cur.val.equals(post.val)){
                if (prev == null){
                    head = post;
                }else{
                    prev.next = post;
                }

                cur = post;
                post = post.next;
                needDelete = false;
            }else{
                prev = cur;
                cur = post;
                post = post.next;
            }
        }

        if(needDelete && prev == null){
            head = null;
        }
        if(needDelete && prev != null){
            prev.next = null;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(3);

        head = deleteDuplicatedNode(head);
        System.out.println(head);
    }
}
