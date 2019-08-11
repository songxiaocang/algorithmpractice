package leetcode;

import util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Songxc
 * @Date: 23:36 2019/8/11
 * @Description: 环形链表 II
 *  给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 *
 *  思路：
 *  1）快慢指针  时间复杂度为0（n），空间复杂度为0（1）
 *  2）哈希表  时间复杂度为0（n），空间复杂度为0（n）
 *  使用哈希表保存之前遍历的每一个节点，当要遍历的下一个节点存在于哈希表中，满足题解返回。
 */
public class T142_DetectNode {
    //快慢指针
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }

        ListNode meetingNode = getMeetingNode(head);
        if(meetingNode == null){
            return null;
        }

        int count = 1;
        ListNode cur = meetingNode;
        while(cur.next != meetingNode){
            cur = cur.next;
            count++;
        }

        ListNode pNode1 = head;
        for(int i=0; i<count; i++){
            pNode1 = pNode1.next;
        }

        ListNode pNode2 = head;
        while(pNode1 != pNode2){
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }

        return pNode1;
    }


    public ListNode getMeetingNode(ListNode node){
        ListNode pSlow = node, pFast = node.next;
        while(pSlow != pFast){
            if(pFast == null || pFast.next == null){
                return null;
            }
            pSlow = pSlow.next;
            pFast = pFast.next.next;
        }
        return pSlow;
    }

    //哈希表
    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        Set<ListNode> visited = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (visited.contains(cur)) {
                return cur;
            }

            visited.add(cur);
            cur = cur.next;
        }

        return null;
    }
}
