package com.gen.linknode;

/**
 * 约瑟夫环形链表问题，输入一个环形单链表的头节点head和报数的K
 * 解法：当链表为空或者为1时，不用调整直接返回，主要找到头节点的前一个节点，
 * 利用该节点进行删除操作
 * @author Genge
 */
public class JosePhusKillNode {

    public static Node kill(Node head, int k){
        if (head == null || k < 0){
            return head;
        }
        int n = 0;
        Node last = head;
        Node cur = head;
        while (last.next != head){
            last = last.next;
        }
        while(cur != last){
            if (++n % k == 0){
                last.next = cur.next;
                n = 0;
            }else {
                last = last.next;
            }
            cur = last.next;
        }
        return cur;
    }
}
