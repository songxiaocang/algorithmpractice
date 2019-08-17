package leetcode;

import util.ListNode;

/**
 * @Author: Songxc
 * @Date: 0:06 2019/8/18
 * @Description: 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 *  输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 *
 * 思路：
 *  使用双指针法
 *   时间复杂度为0（n），空间复杂度0（1），常数级别（仅使用两个中间变量）
 *
 */
public class T160_GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA, node2 = headB;
        int size1 = 0, size2 = 0;
        while(node1 != null){
            node1 = node1.next;
            size1++;
        }
        while(node2 != null){
            node2 = node2.next;
            size2++;
        }

        node1 = headA;
        node2 = headB;
        while(size1 > size2){
            node1 = node1.next;
            size1--;
        }
        while(size2 > size1){
            node2 = node2.next;
            size2--;
        }

        while(node1 != null && node2 != null){
            if(node1 != node2){
                node1 = node1.next;
                node2 = node2.next;
            }else{
                break;
            }
        }

        if(node1 != node2){
            return null;
        }

        return node1;
    }
}
