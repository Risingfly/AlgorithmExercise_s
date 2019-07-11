package com.gen.leetcode.top100;

import java.util.Stack;

/**
 * 问题：234
 * @author Genge
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null){
            return true;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        while (!stack.isEmpty()){
            if (stack.pop().val != cur.val){
                return false;
            }
            cur = cur.next;
        }
        return true;
    }
}
