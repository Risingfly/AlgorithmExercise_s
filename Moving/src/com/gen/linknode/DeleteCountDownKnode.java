package com.gen.linknode;

/**
 * 在单双链表中分别实现删除倒数第K个节点
 * 时间复杂度为O(n)，空间复杂度为O(1)
 *
 * 解法：将K进行减减，当链表结束时k == 0，说明正好为倒数第一个节点；
 * 当链表结束时 k > 0，说明该链表没有倒数第K个节点；当链表结束时 K < 0,
 * 将K从头进行加加，当k == 0时正好是该要删除节点的前一个节点。（n - k + k - n == 0）
 * @author Genge
 */
public class DeleteCountDownKnode {

    public static Node deleteNode(Node head, int k){
        if (head == null){
            return head;
        }
        Node cur = head;
        while (cur != null){
            --k;
            cur = cur.next;
        }
      if (k == 0){
            return head.next;
        }else {
            cur = head;
            while (++k != 0){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;

    }
}
