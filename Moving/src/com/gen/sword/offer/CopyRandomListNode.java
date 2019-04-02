package com.gen.sword.offer;

import com.gen.linknode.RandomNode;

import java.util.HashMap;

/***
 *
 * 问题：复制复杂链表
 * @author Genge
 */
public class CopyRandomListNode {
    public RandomListNode Clone(RandomListNode pHead){
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode cur = pHead;
//        拷贝节点中值
        while (cur != null){
            RandomListNode node = new RandomListNode(cur.label);
            map.put(cur,node);
            cur = cur.next;
        }
        cur = pHead;
//        将拷贝的节点按链连接起来
//        每一个节点都遍历一遍
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(pHead);
    }
}
