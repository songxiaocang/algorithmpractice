package swordOffer;

import util.ListNode;

/**
 * @Author: Songxc
 * @Date: 22:20 2019/5/15
 * @Description: 链表中倒数第k个节点
 * 思路：
 *   注意边界条件和无效输入，采用两个指针先后前进，第一个指针需要先前进K-1步
 */
public class T22_KthNodeFromEnd {
    public static ListNode<Integer> kthNodeFromEnd(ListNode head, int k){
        if (head == null || k <= 0){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        for (int i=0; i<k-1; i++){
            if (fast.next != null){
                fast = fast.next;
            }else{
                return null;
            }
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        System.out.println(kthNodeFromEnd(head,1).val);
        System.out.println(kthNodeFromEnd(head,2).val);
        System.out.println(kthNodeFromEnd(head,3).val);
        System.out.println(kthNodeFromEnd(head,4) == null? null:kthNodeFromEnd(head,4) .val);
    }
}
