package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Songxc
 * @Date: 11:37 2019/8/17
 * @Description: LFU缓存
 * 设计并实现最不经常使用（LFU）缓存的数据结构。它应该支持以下操作：get 和 put。
 *
 * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 * put(key, value) - 如果键不存在，请设置或插入值。当缓存达到其容量时，它应该在插入新项目之前，使最不经常使用的项目无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，最近最少使用的键将被去除。
 *
 * 进阶：
 * 你是否可以在 O(1) 时间复杂度内执行两项操作？
 *
 * 示例：
 *
 * LFUCache cache = new LFUCache( 2 * capacity (缓存容量)  )
 *cache.put(1,1);
 *cache.put(2,2);
 *cache.get(1);       // 返回 1
 *cache.put(3,3);    // 去除 key 2
 *cache.get(2);       // 返回 -1 (未找到key 2)
 *cache.get(3);       // 返回 3
 *cache.put(4,4);    // 去除 key 1
 *cache.get(1);       // 返回 -1 (未找到 key 1)
 *cache.get(3);       // 返回 3
 *cache.get(4);       // 返回 4
 *
 *来源：力扣（LeetCode）
 *链接：https://leetcode-cn.com/problems/lfu-cache
 *
 *  思路：
 *   两个哈希表 + 双向链表
 *    第一个哈希表用于保存插入节点key与节点之间的映射。
 *    第二个哈希表用于纪录节点使用次数相同的情况下，使用时间最早的节点与使用次数count的映射；
 *    维护一个双向链表，链表右边既是最不经常使用的节点
 */
public class T460_LFUCache {
    private Map<Integer, ListNode> cache;//存储key对应的value所在的节点
    private Map<Integer, ListNode> tailMap;//存储每个区间的最左边
    private int capacity;
    private ListNode head;//链表最右边

    //一个简单的链表
    private class ListNode {
        int val, cnt, key;//cnt代表使用次数
        ListNode prev, next;

        public ListNode() {
            this.val = -1;
        }

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            cnt = 0;
        }
    }

    public T460_LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.tailMap = new HashMap<>();
        head = new ListNode();
        head.prev = new ListNode();
        head.prev.next = head;
        tailMap.put(0, head.prev);
    }

    public int get(int key) {
        if (capacity <= 0 || !cache.containsKey(key)) return -1;
        ListNode cur = cache.get(key);
        use(cur);
        return cur.val;
    }

    //使用节点，移动该节点在链表的位置
    private void use(ListNode cur) {
        cur.cnt++;
        if (cur.prev != null) cur.prev.next = cur.next;
        if (cur.next != null) cur.next.prev = cur.prev;
        if (!tailMap.containsKey(cur.cnt)) {
            ListNode node = new ListNode();
            node.next = tailMap.get(cur.cnt - 1);
            node.next.prev = node;
            tailMap.put(cur.cnt, node);
        }
        ListNode tail = tailMap.get(cur.cnt);
        cur.prev = tail;
        cur.next = tail.next;
        tail.next.prev = cur;
        tail.next = cur;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        ListNode node = cache.getOrDefault(key, null);
        if (node != null) {
            node.val = value;
            use(node);
            return;
        }
        if (cache.size() == capacity) removeFirst();
        node = new ListNode(key, value);
        ListNode tail = tailMap.get(node.cnt);
        node.prev = tail;
        node.next = tail.next;
        tail.next.prev = node;
        tail.next = node;
        cache.put(key, node);
    }

    //移除最不常用的节点
    private void removeFirst() {
        ListNode cur = head;
        while (cur.val == -1) {
            cur = cur.prev;
        }
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        cache.remove(cur.key);
    }




}
