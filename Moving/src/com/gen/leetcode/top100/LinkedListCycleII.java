package com.gen.leetcode.top100;

/**
 * 问题：142
 * @author Genge
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast){
//            快指针到达空
            if (fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
