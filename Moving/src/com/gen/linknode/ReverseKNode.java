package com.gen.linknode;

import java.util.Stack;

/***
 * 将单链表的每K个节点之间逆序（重点）
 * @author Genge
 */
public class ReverseKNode {

    public static Node reverse(Node head, int k){
//        N小于2则没有意义
        int N = 2;
        if (head == null || k < N){
            return head;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        Node pre = null;
        Node next = null;
        Node newHead = head;
        int count = 0;
        while (cur != null){
           next = cur.next;
           stack.push(cur);
           if (stack.size() == k){
               pre = linkNew(stack,pre,next);
               newHead = newHead == head ? cur : newHead;
           }
           cur = cur.next;
        }
        return newHead;
    }

    public static Node linkNew(Stack<Node> stack, Node left, Node right){
        Node cur = stack.pop();
        if (left != null){
            left.next = cur;
        }
        Node next = null;
        while (!stack.isEmpty()){
            next = stack.pop();
            cur.next = next;
            cur = next;
        }
        cur.next = right;
        return cur;
    }
}
