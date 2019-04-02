package com.gen.sword.offer;

/**
 * 问题：合并两个单调递增的链表
 * @author Genge
 */
public class MergeLinkNode {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null || list2 == null){
            return list1 == null ? list2 : list1;
        }
//        新的头节点指向最小的那个
        ListNode head = list1.val > list2.val ? list2 : list1;
//        cur1指向头节点
        ListNode cur1 = head;
//        cur2则指向另外一个节点
        ListNode cur2 = head == list1 ? list2 : list1;
        ListNode pre = head;
        ListNode next = null;

        while (cur1 != null && cur2 != null){
            if (cur1.val <= cur2.val){
                next = cur2.next;
                cur2.next = cur1.next;
                pre.next = cur2;
                cur1 = cur2.next;
                pre = cur2.next;

                cur2 = next;
            }else {
                pre = cur1;
                cur1 = cur1.next;
            }
        }
        if (cur1 != null){
            pre.next = cur1;
        }
        if (cur2 != null){
            pre.next = cur2;
        }
        return head;
    }
}
