package com.gen.leetcode.top100;

import java.util.PriorityQueue;

/**
 * 问题：23
 * 思路：使用到堆结构的优先队列，将所有链表头节点加入优先队列，同时建立一个傀儡节点，
 * 队列出队的节点就是几个有序链表中最小的，将其设为傀儡节点的下一个节点，若该节点的下一个
 * 节点不为空，则将其入队，重复以上过程直到队列为空，最后返回傀儡节点的下一节点为头节点即可
 * @author Genge
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length, (a, b)-> a.val-b.val);
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for(ListNode node :lists){
            if (node != null){
                queue.add(node);
            }
        }
        while (!queue.isEmpty()){
            tail.next = queue.poll();
//            更新tail
            tail = tail.next;
            if (tail.next != null){
                queue.add(tail.next);
            }
        }
        return dummy.next;
    }
}
