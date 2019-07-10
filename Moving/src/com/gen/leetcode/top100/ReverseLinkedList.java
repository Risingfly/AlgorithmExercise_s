package com.gen.leetcode.top100;

/**
 * 问题：206
 * @author Genge
 */
public class ReverseLinkedList {
     public ListNode reverseList3(ListNode head,ListNode newHead){
         if (head == null){
//             当链表到达末尾时，返回新的头节点
             return newHead;
         }
         ListNode next = head.next;
         head.next = newHead;
         newHead = head;
         return reverseList3(next,newHead);
     }
     public ListNode reverseList2(ListNode head) {
         if (head == null || head.next == null){
             return head;
         }
         ListNode tmp = reverseList(head.next);
         head.next.next = head;
         head.next = null;
         return tmp;
     }
    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
