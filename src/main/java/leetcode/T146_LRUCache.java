package leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: Songxc
 * @Date: 23:04 2019/8/12
 * @Description:  LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 *
 *  思路：
 *   有两种解决办法： 有序字典和哈希表+双向链表
 *   1）有序字典 时间复杂度为0（1）， 空间复杂度为0（capacity）
 *      有序字典的（get/put/remove/containsKey）这些操作都可以在常数时间内完成
 *   2）哈希表+双向链表 时间复杂度为0（1）， 空间复杂度为0（capacity）
 *   使用双向链表的一个好处是不需要额外信息删除一个节点，同时可以在常数时间内从头部或尾部插入删除节点。
 *      双向链表使用伪头部和伪尾部，这样在更新的时候就不需要检查当前节点是否为null节点
 */
public class T146_LRUCache {
    //哈希表+双向链表
    private Map<Integer, LinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private LinkedNode head, tail;

    class LinkedNode{
        int key;
        int value;
        LinkedNode prev;
        LinkedNode next;
    }

    public void addNode(LinkedNode node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(LinkedNode node){
        LinkedNode prev = node.prev;
        LinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }


    public void moveToHead(LinkedNode node){
        removeNode(node);
        addNode(node);
    }

    public LinkedNode popTail(){
        LinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    public T146_LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        LinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }

        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        LinkedNode node = cache.get(key);
        if(node == null){
            LinkedNode newNode = new LinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);
            size++;

            if(size > capacity){
                LinkedNode tailNode = popTail();
                cache.remove(tailNode.key);
                size--;
            }

        }else{
            node.value = value;
            moveToHead(node);
        }
    }

    //有序字典
    class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }




}
