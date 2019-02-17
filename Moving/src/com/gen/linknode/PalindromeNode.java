package com.gen.linknode;

import java.util.Stack;
/**
 * 判断该节点是否为回文节点
 * 解法：使用栈结构，将所有数据压入栈中再弹出，进行对比即可。
 * @author Genge
 */
public class PalindromeNode {

    public static boolean isPalindromeNode(Node head){
        if (head == null){
            return false;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.isEmpty() && head != null){
            if (stack.pop().val != head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
