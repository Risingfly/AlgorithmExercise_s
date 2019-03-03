package com.gen.linknode;

import java.util.HashSet;

/***
 *
 * 删除无序单链表中值重复出现的节点
 * 解法：哈希表
 * @author Genge
 */
public class DeleteRepeatNode {

    public static Node deleteNode(Node head){
        if (head == null){
            return head;
        }
        HashSet<Integer> set = new HashSet<>();
        Node pre = head;
        Node cur = head.next;
        set.add(head.val);
        while (cur != null){
            if (set.contains(cur.val)){
                pre.next = cur.next;
            }else {
                set.add(cur.val);
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
