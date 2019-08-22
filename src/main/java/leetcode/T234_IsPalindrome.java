package leetcode;

import util.ListNode;

/**
 * @Author: Songxc
 * @Date: 23:49 2019/8/22
 * @Description:  回文链表
 *  请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 *
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 *
 *  思路：
 *  快慢指针法
 *   反转前半部分链表然后与后半部分链表的节点依次对比，直接两链表结束。如果两个链表对应节点值全部匹配相等，则该链表为回文链表
 *   时间复杂度为0（n）， 空间复杂度为0（1） （占用了常量级别的空间消耗）
 */
public class T234_IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head, fast = slow.next, prev = null;
        //反转前半部分链表
        while (fast != null) {
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
            if (fast.next != null) {
                fast = fast.next.next;
                if (fast == null) {
                    slow = slow.next;
                }
            } else {
                fast = fast.next;
            }
        }

        //比对两个链表
        ListNode p1 = prev, p2 = slow;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }
}
