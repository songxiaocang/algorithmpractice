package swordOffer;

import util.ListNode;

/**
 * @Author: Songxc
 * @Date: 22:56 2019/5/21
 * @Description: 反转链表
 * 思路：
 *   定义三个指针 prev cur post，改变prev cur的指向，并依次后移prev cur post。
 */
public class T24_ReverseList {
    public static ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;
        ListNode post = head.next;
        while(true){
            cur.next = prev;
            prev = cur;
            cur = post;
            if(post != null){
                post = post.next;
            }else{
                return prev;
            }
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(reverseList(head));
    }
}
