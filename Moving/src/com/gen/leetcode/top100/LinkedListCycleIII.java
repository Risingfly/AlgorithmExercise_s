package com.gen.leetcode.top100;

/**
 * 问题：160
 * 思路：一，求差之，计算两链表的长度差，让其一先走一段，然后二者同时走，第一个相遇的即是
 *       二，当其中一个走到空的时候，让其从另外一个头部开始走，相遇即可
 *       l1: a + c(common)
 *       l2: b + c(common)
 *       switch:==> a + c + b + c == b + c + a + c
 *       最终相遇在走了a + b + c步后，若c = 0；则相遇在null(思路牛逼)
 * @author Genge
 */
public class LinkedListCycleIII {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        int count = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA.next != null){
            count++;
            curA = curA.next;
        }
        while (curB.next != null){
            count--;
            curB = curB.next;
        }
        if (curA.val != curB.val){
            return null;
        }
        ListNode cur = count > 0 ? headA : headB;
        ListNode tmp = cur == headA ? headB : headA;
        count = Math.abs(count);
        while (count-- != 0){
            cur = cur.next;
        }
        while (cur != tmp){
            cur = cur.next;
            tmp = tmp.next;
        }
        return cur;

    }
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }
}
