package com.gen.sword.offer;

/**
 *
 * 问题：给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * @author Genge
 */
public class LoopNode {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null){
            return null;
        }
//        慢指针初始指向头节点的下一个节点，快指针指向头节点的下下个节点
        ListNode slow = pHead.next;
        ListNode fast = pHead.next.next;
//        快慢两个指针，若不相遇则无环
        while (fast != slow){
            if (fast.next == null || fast.next.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
//        相遇则将快指针从头开始，并变成慢指针，俩再次相遇的地方为
//        第一个入环的节点
        fast = pHead;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
