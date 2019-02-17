package com.gen.linknode;


/**
 * 删除链表的中间节点和a/b处的节点
 * 解法：三个以上节点，pre指向头节点，cur指向第三个节点，当cur.next != null && cur.next.next != null
 * 时，pre节点永远指向被删除中间节点的前一个（无论奇偶数）
 * @author Genge
 */
public class DeleteMiddNode {

    public static Node deletMidNode(Node head){
        if (head == null || head.next == null){
            return head;
        }
        if (head.next.next == null){
            return head.next;
        }
        //重要：无论奇偶数寻找中间节点的方法
        Node pre = head;
        Node cur = head.next.next;
        while (cur.next != null && cur.next.next != null){
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
