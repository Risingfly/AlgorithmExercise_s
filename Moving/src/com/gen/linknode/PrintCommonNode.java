package com.gen.linknode;

/**
 * 打印两个有序链表的公共部分
 * @author Genge
 */
public class PrintCommonNode {

    public static void printCommon(Node head1, Node head2){
        if (head1 == null || head2 == null){
            return;
        }
        while (head1 != null && head2 != null){
            if (head1.val < head2.val){
                head1 = head1.next;
            }else if (head1.val > head2.val){
                head2 = head2.next;
            }else {
                System.out.println("res="+head1.val);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }
}
