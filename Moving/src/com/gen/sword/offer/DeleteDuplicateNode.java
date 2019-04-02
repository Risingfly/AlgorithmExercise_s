package com.gen.sword.offer;

import java.util.HashSet;

/**
 *
 * 问题：删除排序链表中重复的节点
 * 解法：要新建一个头节点作为trick，后面遇到相同的则一直遍历，直到不同位置，
 * @author Genge
 */
public class DeleteDuplicateNode {
    public ListNode deleteDuplication(ListNode pHead){
        if (pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode first = new ListNode(-1);
        first.next = pHead;

        ListNode p = pHead;
        ListNode last = first;

        while (p != null && p.next != null){
            if (p.val == p.next.val){
                int val = p.val;
                while (p != null && p.val == val){
                    p = p.next;
                }
                last.next = p;
            }else {
                last = p;
                p = p.next;
            }
        }
        return first.next;
    }
}
