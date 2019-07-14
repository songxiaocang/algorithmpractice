package leetcode;

import util.ListNode;

/**
 * @Author: Songxc
 * @Date: 19:48 2019/7/14
 * @Description: 合并两个有序链表
 *  将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 *  思路:
 *  1） 递归
 *  2） 迭代/循环
 *   使用归并排序，时间复杂度为0（m+n）
 *    空间复杂度为 0（1），因为在求解过程中，只会产生几个纪录变量的指针，复杂度在常数级别
 */
public class T21_MergeSortedLinkedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        while (l1 != null && l2 != null) {
            if ((int) l1.val < (int) l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dummyNode.next;
    }
}
