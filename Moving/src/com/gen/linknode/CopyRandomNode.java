package com.gen.linknode;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * 复制含有随机指针节点的链表
 * @author Genge
 */
public class CopyRandomNode {

    public static RandomNode copyNode(RandomNode head){
        HashMap<RandomNode,RandomNode> map = new HashMap<>(8);
        RandomNode cur = head;
        while (cur != null){
            map.put(cur,new RandomNode(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }
}
