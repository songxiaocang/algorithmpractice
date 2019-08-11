package swordOffer;

import util.ListNode;

/**
 * @Author: Songxc
 * @Date: 23:28 2019/5/20
 * @Description: 求链表中环的入口节点
 *  思路：
 *    快慢指针
 *    1）使用一快一慢指针判断是否有环；求得相遇节点；
 *    2）根据相遇节点求环的节点数；
 *    3）两支针速度相同同向移动直至相遇，相遇节点即为入口节点。
 */
public class T23_EntryNodeOfLoop {
    public static ListNode entryNodeOfLoop(ListNode head){
       ListNode meetingNode = meetingNode(head);
       if (meetingNode == null){
           return null;
       }

       int count = 1;
       ListNode pNode1 = meetingNode;
       while(pNode1.next != meetingNode){
           pNode1 = pNode1.next;
           count++;
       }

       pNode1 = head;
       for(int i=0;i<count;i++){
           pNode1 = pNode1.next;
       }

       ListNode pNode2 = head;
       while(pNode1 != pNode2){
           pNode1 = pNode1.next;
           pNode2 = pNode2.next;
       }

       return pNode1;
    }

    public static ListNode meetingNode(ListNode head){
        if(head == null || head.next == null){
            return null;
        }
        ListNode pSlow = head.next;
        ListNode pFast = pSlow.next;
        while(pSlow != null && pFast != null){
            if (pSlow == pFast){
                return pSlow;
            }

            pSlow = pSlow.next;
            pFast = pFast.next;
            if (pFast != null){
                pFast = pFast.next;
            }
        }

        return null;

        //获取相遇节点方法2：
//        while(pSlow != pFast){
//            if(pFast == null || pFast.next == null){
//                return null;
//            }
//            pSlow = pSlow.next;
//            pFast = pFast.next.next;
//        }
//        return pSlow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        ListNode secondNode = head.next;
        ListNode tailNode = head.next.next.next;
        tailNode.next = secondNode;

        System.out.println(entryNodeOfLoop(head) == null? null:entryNodeOfLoop(head).val);

    }
}
