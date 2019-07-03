package com.gen.leetcode.top100;

/**
 *  问题：19
 * @author Genge
 */
public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        while (cur != null){
            n--;
            cur = cur.next;
        }
        if (n >= 0){
            return head.next;
        }
        // if (n > 0){
        //     return head;
        // }
        cur = head;
        while (cur != null){
            if (++n == 0){
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
        return head;
    }
}
