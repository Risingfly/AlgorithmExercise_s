package com.gen.leetcode.top100;

/**
 * 问题：2
 * @author Genge
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
        ListNode head = new ListNode(0);
        ListNode newHead = head;
        int sum = 0;
        while (l1 != null || l2 != null){
//            取进位
            sum /= 10;
            if (l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            head.next = new ListNode(sum % 10);
            head = head.next;
        }
//        进位为1则需再增加一个节点（进位也最多为1）
        if ((sum / 10) == 1){
            head.next = new ListNode(1);
        }
        return newHead.next;
    }
}
