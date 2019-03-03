package com.gen.linknode;

/**
 * 一种怪异的节点删除方式
 * @author Genge
 */
public class DeleteWiredNode {

    public static void removeWiredNode(Node node){
        if (node == null){
            return;
        }
        Node next = node.next;
        if (next == null){
            throw new RuntimeException("can not delete the last node!");
        }
        node.val = next.val;
        node.next = next.next;
    }
}
