package com.gen.linknode;


import java.util.Scanner;

/**
 * 如何判断一个链表有环，如果有，则返回第一个进入环的节点，如果没有则返回null
 * 解法：设置快慢两个指针，快指针每次移动两步，慢指针移动一步，若无环，则快指针一定
 * 先到终点，否则快慢会相遇，此时，将快指针重新置为头节点，慢指针保持不变，
 * 同时快指针改为每次移动一步，当二者再次相遇的时候，说明该节点即为所求节点。
 * @author Genge
 */
public class LoopNode {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strs = str.split(",");
        if (strs.length > 1000){
            return;
        }

    }
    public static boolean isLoopNode(String[] strs){
        if (strs == null || strs.length < 3 || strs.length > 1000){
            return false;
        }
        int slow = 0;
        int fast = 2;
        while (slow != fast && fast < strs.length){
            if (strs[slow].equals(strs[fast])){
                return true;
            }
            slow++;
            fast += 2;
        }
        return false;
    }
    public static Node getLoopNode(Node head){
        if (head == null || head.next == null || head.next.next == null){
            return head;
        }
        Node slow = head;
        Node fast = head.next.next;
        while (slow != fast){
            if (fast == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

}
