package com.gen.linknode;

/***
 * 按照左右半区的方式重新组合单链表
 * 解法：找到中间值，从长度为2开始每增加2，mid即往后增加1，本质是将右侧链表插入左侧链表的过程。
 * @author Genge
 */
public class LeftAndRightMergeNode {

    public static void relocate(Node head){
        if (head == null || head.next == null){
            return;
        }
        Node mid = head;
        Node right = head;
        while (right.next != null && right.next.next != null){
            mid = mid.next;
            right = right.next;
        }
        right = mid.next;
        mid.next = null;

    }
    public static void merge(Node left, Node right){
        Node next = null;
        while (left.next != null){
            next = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = next;
        }
        left.next = right;
    }
}
