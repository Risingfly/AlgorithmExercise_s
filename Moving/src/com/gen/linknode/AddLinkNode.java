package com.gen.linknode;


import java.util.Stack;

/**
 * 两个单链表生成相加链表
 * 解法：建立两个栈，分别将数据压栈，然后出栈，正好满足加法（头插法）
 * @author Genge
 */
public class AddLinkNode {

    public static Node add(Node head1, Node head2){
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (head1 != null){
            s1.push(head1.val);
            head1 = head1.next;
        }
        while (head2 != null){
            s2.push(head2.val);
            head2 = head2.next;
        }

        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        Node node = null;
        Node pre = null;
        while (!s1.isEmpty() || !s2.isEmpty()){
            n1 = s1.isEmpty() ? 0 : s1.pop();
            n2 = s2.isEmpty() ? 0 : s2.pop();
            n = n1 + n2 + ca;
            //头插法
            pre = node;
            node = new Node(n % 10);
            node.next = pre;
            ca = n / 10;
        }
        if (ca == 1){
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        return node;
    }

}
