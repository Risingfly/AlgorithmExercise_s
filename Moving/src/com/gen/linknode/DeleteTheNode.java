package com.gen.linknode;

/***
 * 单链表中删除指定值的节点
 * @author Genge
 */
public class DeleteTheNode {

    public static Node deleteNode(Node head, int val){
        if (head == null || val < 0){
            return head;
        }
        while (head.val == val){
            head = head.next;
        }
//        Node newHead = head;
        Node pre = head;
        Node cur = head.next;
        while (cur != null){
            if (cur.val == val){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
