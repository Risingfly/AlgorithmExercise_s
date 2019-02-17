package com.gen.linknode;


/**
 * 反转单向和双向链表
 * 解法：将当前节点的下一节点保存起来（next），将下一节点指向当前节点(head.next)，然后前置节点
 * 指向当前节点(pre)，当前节点指向保存节点继续循环
 * 双向链表同理
 * @author Genge
 */
public class ReverseListNode {

    public static Node reverse(Node head){

        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
