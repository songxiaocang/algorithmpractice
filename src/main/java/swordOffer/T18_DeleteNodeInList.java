package swordOffer;

import util.ListNode;

/**
 * @Author: Songxc
 * @Date: 23:31 2019/5/5
 * @Description: 删除链表的节点 要求：时间复杂度为O(1)
 * 思路：
 *  该解法实现的前提是已知节点在链表中
 *  对于要删除节点，不是最后一个节点，直接将要删除节点的next节点的值赋值到要删除节点，然后改变指针的指向；
 *  如果是最后一个节点，需要从前往后一次遍历到最后一个节点的前一个节点，然后将它的next节点置为null
 *
 */
public class T18_DeleteNodeInList {

    public static ListNode deleteNodeInList(ListNode head, ListNode node){
        if(head == node){
            return head.next;
        }else if(node.next!=null){
            node.val = node.next.val;
            node.next = node.next.next;
            return head;
        }else{
            ListNode temp = head;
            while(temp.next!= node){
                temp = temp.next;
            }
            temp.next = null;
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        System.out.println(head);
        deleteNodeInList(head,head.next);
        System.out.println(head);
        deleteNodeInList(head,head.next);
        System.out.println(head);

    }

}
