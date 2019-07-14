package leetcode;

import util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: Songxc
 * @Date: 21:10 2019/7/14
 * @Description: 合并k个有序链表
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/submissions/
 * 思路：
 * 1） 优先队列   时间复杂度0（nlogk） 空间复杂度为0（n）
 * 时间复杂度： O(Nlog⁡k)O(N\log k)O(Nlogk) ，其中 k\text{k}k 是链表的数目。
 * 弹出操作时，比较操作的代价会被优化到 O(log⁡k)O(\log k)O(logk) 。同时，找到最小值节点的时间开销仅仅为 O(1)O(1)O(1)。
 * 最后的链表中总共有 NNN 个节点。
 * 空间复杂度：
 * O(n)O(n)O(n) 。创造一个新的链表需要 O(n)O(n)O(n) 的开销。
 * O(k)O(k)O(k) 。以上代码采用了重复利用原有节点，所以只要 O(1)O(1)O(1) 的空间。同时优先队列（通常用堆实现）需要 O(k)O(k)O(k) 的空间（远比大多数情况的 NNN要小）。
 * 2） 分治 + 归并
 * 时间复杂度 0(nlogk)  空间复杂度：0（1）
 */
public class T23_MergeKLinkedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if ((int) o1.val < (int) o2.val) {
                    return -1;
                } else if (o1.val == o2.val) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }

        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null) {
                queue.add(cur.next);
            }
        }
        return dummyNode.next;

    }
}
