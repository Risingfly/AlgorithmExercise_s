package com.gen.leetcode.top100;

import java.util.HashMap;

/**
 * 问题：实现LRU（最近最少使用）
 *
 * @author Genge
 */
public class LRUCache {
    /**
     * 用来存储key - value 将链表节点进行存储，该map的key和链表的域key相同
     */
    private HashMap<Integer,DLinkedNode> cache = new HashMap<>();
    /**
     * 记录当前链表和哈希表中存储的节点个数（不包括头尾节点）
     */
    private int count;
    /**
     * 初始容量
     */
    private int capacity;
    /**
     * 链表的头尾节点，不实际存储值，为简化代码和插入删除操作而造
     * ______     _____
     * |head |-->|     |
     * |_____|<-- |tail_|_
     */
    private DLinkedNode head,tail;

    public LRUCache(int capacity){
        this.count = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    /**
     * 存储key - value的双向链表
     */
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }

    /**
     * 添加节点，永远添加在头部的下一个节点
     * @param node
     */
    private void addNode(DLinkedNode node){
        node.pre = head;
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
    }

    /**
     * 删除某个节点，记录该节点的前后节点，然后删除
     * @param node
     */
    private void removeNode(DLinkedNode node){
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    /**
     * 核心方法：每次访问操作，都需要执行该方法（实现LRU的核心方法之一）
     * 先删除该节点，然后新建该节点（新建节点总是在头部下一个）
     * @param node
     */
    private void moveToHead(DLinkedNode node){
        this.removeNode(node);
        this.addNode(node);
    }

    /**
     * 核心方法：如果当前链表容量大于设置的，则进行淘汰，执行该方法（LRU核心方法之一）
     * 从尾部删除节点（链表尾部既是当前最近最少使用的节点），删除利用尾节点操作
     * @return
     */
    private DLinkedNode popTail(){
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    /**
     * 先从hashmap中进行查找该节点，若不存在返回-1；若存在，将该节点执行moveToHead()方法，
     * 即将其移到头节点处
     * @param key
     * @return
     */
    public int get(int key){
        DLinkedNode node = cache.get(key);
        if (node == null){
            return -1;
        }
        this.moveToHead(node);
        return node.value;
    }

    /**
     * 先从hashmap中进行查找，若存在则将该值覆盖为新值，其他不变；
     * 若不存在，则新建一个链表节点存储kv，然后先将其放入到hashmap中，
     * 然后加入链表中，同时将count节点数量加1，再判断是否大于初始容量，
     * 若大于则从尾部删除最近最少使用的节点，同时在hashmap中也删除，再将
     * 数量减一。
     * @param key
     * @param value
     */
    public void put(int key,int value){
        DLinkedNode node = cache.get(key);
        if (node == null){
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            this.cache.put(key,newNode);
            this.addNode(newNode);
            ++count;
            if (count > capacity){
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        }else {
            node.value = value;
            this.moveToHead(node);
        }
    }
}
