package com.gen.linknode;

/***
 * 单链表的选择排序
 * 解法：每次选择该链表的最小节点，生成一个新的链表，当原链表被删完则新链表，
 * 已建成。
 * @author Genge
 */
public class NodeSelectionSort {

    public static Node selection(Node head){
        Node tail = null;
        Node cur = head;
        Node smallPre = null;
        Node small = null;

        while (cur != null){
            small = cur;
            smallPre = getSmallPreNode(cur);
            if (smallPre != null){
                small = smallPre.next;
                smallPre.next = small.next;
            }
            cur = cur == small ? cur.next : cur;
            if (tail == null){
                head = small;
            }else {
                tail.next = small;
            }
            tail = small;
        }
        return head;
    }

    public static Node getSmallPreNode(Node head){
        if (head == null){
            return head;
        }
        Node pre = head;
        Node cur = head.next;
        Node small = head;
        Node smallPre = null;

        while (cur != null){
            if (cur.val < small.val){
                small = cur;
                smallPre = pre;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallPre;
    }
}
