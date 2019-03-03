package com.gen.linknode;

/***
 * 合并两个有序的单链表
 * 解法：将头节点值大的链表插入头节点小的头节点链表中
 * @author Genge
 */
public class MergeOrderNode {

    public static Node merge(Node head1, Node head2){
        if (head1 == null || head2 == null){
            return head1 != null ? head1 : head2;
        }
        Node head = null;
        head = head1.val < head2.val ? head1 : head2;
        Node cur1 = head == head1 ? head1 : head2;
        Node cur2 = head == head1 ? head2 : head1;
        Node pre = null;
        Node next = null;
        while (cur1 != null && cur2 != null){
            if (cur1.val <= cur2.val){
                pre = cur1;
                cur1 = cur1.next;
            }else {
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;
            }
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return head;

    }
}
