package leetcode;

import util.ListNode;

/**
 * @Author: Songxc
 * @Date: 18:28 2019/7/14
 * @Description: 排序链表
 * 思路：
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 思路：
 * 使用归并排序
 * 先从链表中点处（奇数情况下为正中间位置，偶数情况下为左边左一元素）
 * 时间复杂度 0（nlogn） 空间复杂度为0(n)
 */
public class T148_SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        while (left != null && right != null) {
            if ((int) left.val < (int) right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left != null ? left : right;

        return dummyNode.next;
    }
}
