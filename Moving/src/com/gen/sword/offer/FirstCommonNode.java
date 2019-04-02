package com.gen.sword.offer;

/***
 *
 * 问题：找出两个链表的第一个公共节点
 * @author Genge
 */
public class FirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null){
            return null;
        }
        while (pHead1 != null && pHead2 != null){
            if (pHead1.val == pHead2.val){
                return pHead1;
            }else if (pHead1.val < pHead2.val){
                pHead1 = pHead1.next;
            }else {
                pHead2 = pHead2.next;
            }
        }
        return null;
    }
}
