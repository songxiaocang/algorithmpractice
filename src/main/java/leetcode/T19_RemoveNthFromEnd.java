package leetcode;

import util.ListNode;

/**
 * @Author: Songxc
 * @Date: 17:16 2019/7/14
 * @Description: 删除链表的倒数第N个节点
 * 思路：
 * 使用前后指针，时间复杂度为0（n），空间复杂度0（1）
 */
public class T19_RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode first = dummyNode, second = dummyNode;
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummyNode.next;
    }
}
