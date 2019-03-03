package com.gen.linknode;

/**
 * 向有序的环形单链表中插入新节点
 * 解法：设置两个节点，pre cur当找到位于pre.val 和 cur.val之间的值即可插入，
 * 若寻找一圈依然没有找到，则该待插入值，要么大于head（返回head）要么小于head(返回node)，
 * @author Genge
 */
public class InsertLoopNode {
    public static Node insert(Node head, int k){
        Node node = new Node(k);
        if (head == null){
            node.next = node;
            return node;
        }

        Node pre = head;
        Node cur = head.next;
        while (cur != head){
            if (node.val > pre.val && node.val < cur.val){
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = node;
        node.next = cur;
        return head.val < node.val ? head : node;
    }
}
