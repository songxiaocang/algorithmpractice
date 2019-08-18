package leetcode;

import util.ListNode;

/**
 * @Author: Songxc
 * @Date: 13:10 2019/8/18
 * @Description: 反转链表
 *  反转一个单链表。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 思路；
 *  有递归和迭代两种方式
 *  1） 迭代
 *  在遍历列表时，将当前节点的 next 指针改为指向前一个元素。由于节点没有引用其上一个节点，因此必须事先存储其前一个元素。在更改引用之前，还需要另一个指针来存储下一个节点。不要忘记在最后返回新的头引用！
 * 时间复杂度：O(n)，假设 n 是列表的长度，时间复杂度是 O(n)。
 * 空间复杂度：O(1)。
 *
 * 2） 递归
 * 若从节点 Nk+1 到 Nm已经被反转，而我们正处于 Nk​。
 *
 * N1→...→Nk−1→Nk→Nk+1←...←Nm
 * 我们希望 Nk+1 的下一个节点指向 Nk​。
 * 所以，Nk.next.next = Nk​。
 * 要小心的是 n1 的下一个必须指向 Ø 。如果你忽略了这一点，你的链表中可能会产生循环。如果使用大小为 2 的链表测试代码，则可能会捕获此错误。
 *
 * 时间复杂度：O(n)，假设 n 是列表的长度，那么时间复杂度为 O(n)。
 * 空间复杂度：O(n)，由于使用递归，将会使用隐式栈空间。递归深度可能会达到 n 层。
 *
 */
public class T206_ReverseList {
    //迭代
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    //递归
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

}
