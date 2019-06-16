package swordOffer;

import util.ListNode;

import java.util.Stack;

/**
 * @Author: Songxc
 * @Date: 18:50 2019/6/16
 * @Description:  两个链表的第一个公共节点
 *  思路：
 *    对于两种长度分别为m和n的链表，有三种方法：
 *               暴力破解法     双栈法    一前一后指针法
 *   时间复杂度    0(mn)        0(m+n)     O(m+n)
 *   空间复杂度    O(1)         0(m+n)      0(1)
 */
public class T52_FirstCommonNodeInLinkedList {

    public static ListNode<Integer> solution1(ListNode<Integer> head1, ListNode<Integer> head2){
        if (head1== null || head2 == null){
            return null;
        }

        for (ListNode<Integer> node1=head1; node1 != null;node1=node1.next){
            for (ListNode<Integer> node2=head2; node2 !=null; node2=node2.next){
                if (node1==node2){
                    return node1;
                }
            }
        }
        return null;
    }


    public static ListNode<Integer> solution2(ListNode<Integer> head1, ListNode<Integer> head2){
        Stack<ListNode<Integer>> stack1 = new Stack<>();
        Stack<ListNode<Integer>> stack2 = new Stack<>();
        ListNode<Integer> node1 = head1;
        ListNode<Integer> node2 = head2;
        while(node1 != null){
            stack1.push(node1);
            node1 = node1.next;
        }
        while(node2 != null){
            stack2.push(node2);
            node2 = node2.next;
        }
        ListNode<Integer> commonNode = null;
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            if (stack1.peek() == stack2.peek()){
                commonNode = stack1.pop();
                stack2.pop();
            }else{
                break;
            }
        }

        return commonNode;

    }

    public static ListNode<Integer> solution3(ListNode<Integer> head1, ListNode<Integer> head2){
        ListNode<Integer> node1 = head1;
        ListNode<Integer> node2 = head2;

        int size1=0,size2=0;
        while(node1 != null){
            node1 = node1.next;
            size1++;
        }
        while(node2 != null){
            node2 = node2.next;
            size2++;
        }

        node1 = head1;
        node2 = head2;
        while(size1>size2){
            node1=node1.next;
            size1--;
        }
        while(size2>size1){
            node2=node2.next;
            size2--;
        }

        while(node1 != null && node2 != null){
            if (node1 != node2){
                node1 = node1.next;
                node2 = node2.next;
            }else{
                break;
            }
        }
        if (node1 != node2){
            return null;
        }
        return node1;
    }

    public static void main(String[] args) {
        ListNode<Integer> node1 = new ListNode<>(1);
        ListNode<Integer> node2 = new ListNode<>(2);
        ListNode<Integer> node3 = new ListNode<>(3);
        ListNode<Integer> node4 = new ListNode<>(4);
        ListNode<Integer> node5 = new ListNode<>(5);
        ListNode<Integer> node6 = new ListNode<>(6);
        ListNode<Integer> node7 = new ListNode<>(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node6;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        System.out.println(solution1(node1, node4).val);
        System.out.println(solution2(node1, node4).val);
        System.out.println(solution3(node1, node4).val);
    }
}
