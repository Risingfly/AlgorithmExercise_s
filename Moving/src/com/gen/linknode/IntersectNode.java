package com.gen.linknode;

/***
 * 判断两个无环链表是否相交，相交则返回第一个相交节点，不相交则返回null
 * 解法：分别计算两个链表的长度，和最后一个节点，如果最后一个节点不相同，
 * 则说明不会相交（无环链表），若相交，则让长链表先走n（差值）步，然后，
 * 一起走，当相交时，则为第一个相交节点。
 * @author Genge
 */
public class IntersectNode {

    public static Node intersectNode(Node head1, Node head2){
        if (head1 == null || head2 == null){
            return head1 == null ? head2 : head1;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int count = 0;
        while (cur1.next != null){
            count++;
            cur1 = cur1.next;
        }
        while (cur2.next != null){
            count--;
            cur2 = cur2.next;
        }
        //最终节点不相等，即不相交（无环节点）
        if (cur1 != cur2){
            return null;
        }
        cur1 = count > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        count = Math.abs(count);

        while (count != 0){
            count--;
            cur1 = cur1.next;
        }
        //当两个节点相交即为第一个相交节点
        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}
