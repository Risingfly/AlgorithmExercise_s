package com.gen.sword.offer;

import java.util.ArrayList;

public class FromTailToPrint {
    private ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode next = null;
        ListNode pre = null;
        while (listNode != null){
            next = listNode.next;
            listNode.next = pre;
            pre = listNode;
            listNode = next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (pre != null){
            next = pre.next;
            list.add(pre.val);
            pre = next;
        }
        return list;
    }
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode){
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null){
            return list;
        }else {
            printListFromTailToHead2(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
}
