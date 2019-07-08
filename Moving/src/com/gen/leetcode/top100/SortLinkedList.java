package com.gen.leetcode.top100;

/**
 * 问题：148单链表排序
 * 核心思路：单链表归并排序，不需要额外数组（但递归要压栈）
 * @author Genge
 */
public class SortLinkedList {
    public ListNode sortList(ListNode head) {
//        递归出口
        if (head == null || head.next == null){
            return head;
        }
//        处理当前层逻辑
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
//        左右再递归划分
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
//        合并
        return merge(l1,l2);
    }
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode tmp = new ListNode(0);
        ListNode cur = tmp;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null){
            cur.next = l1;
        }
        if (l2 != null){
            cur.next = l2;
        }
        return tmp.next;
    }
}
