package com.gen.leetcode.linknode;

/**
 * 问题：反转单链表
 * @author Genge
 */
public class ReverseNode {
    public ListNode reverseList(ListNode head) {
//        递归出口
        if(head == null || head.next == null){
            return head;
        }
        ListNode realHead = reverseList(head.next);
//        此时head为倒数第二个节点
//        则head.next为倒数第一
//        将倒一的next指针指向倒数第二
        head.next.next = head;
//        将倒数第二个节点断开（之前的方向）
        head.next = null;
        return realHead;
    }
    public ListNode reverseList2(ListNode head){
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
