package swordOffer;

import util.ListNode;

/**
 * @Author: Songxc
 * @Date: 11:10 2019/5/25
 * @Description: 合并两个有序链表
 *  思路：
 *   类似于归并排序
 *   有递归与非递归两种方式
 *   递归：定义一个合并head
 *   非递归：确定一个新的index
 */
public class T25_MergeSortedLists {
    //递归
    public static ListNode mergerSortListsRecursion(ListNode<Integer> head1, ListNode<Integer> head2){
        if (head1 == null){
            return head2;
        }
        if (head2 == null){
            return head1;
        }

        ListNode<Integer> mergeHead = null;
        if(head1.val < head2.val){
            mergeHead = head1;
            mergeHead.next = mergerSortListsRecursion(head1.next, head2);
        }else{
            mergeHead = head2;
            mergeHead.next = mergerSortListsRecursion(head1, head2.next);
        }
        return mergeHead;
    }

    //非递归
    public static ListNode<Integer> mergeSortedListsNotRecursion(ListNode<Integer> head1, ListNode<Integer> head2){
        if (head1 == null){
            return head2;
        }
        if (head2 == null){
            return head1;
        }
        ListNode<Integer> index1 = head1;
        ListNode<Integer> index2 = head2;
        ListNode<Integer> index = null;
        if (head1.val < head2.val){
            index = index1;
            index1 = index1.next;
        }else{
            index = index2;
            index2 = index2.next;
        }

        while(index1 != null && index2 != null){
            if(index1.val <index2.val){
                index.next = index1;
                index = index.next;
                index1 = index1.next;
            }else{
                index.next = index2;
                index = index.next;
                index2 = index2.next;
            }
        }

        if(index1 != null){
            index.next = index1;
        }
        if (index2 != null){
            index.next = index2;
        }
        return head1.val < head2.val ? head1 : head2;
    }

    public static void main(String[] args) {
        ListNode<Integer> head1 = new ListNode<Integer>(1);
        head1.next = new ListNode<Integer>(3);
        head1.next.next = new ListNode<Integer>(7);

        ListNode<Integer> head2 = new ListNode<Integer>(2);
        head2.next = new ListNode<Integer>(4);
        head2.next.next = new ListNode<Integer>(6);
//        System.out.println(mergerSortListsRecursion(head1, head2));
        System.out.println(mergeSortedListsNotRecursion(head1, head2));

    }
}
