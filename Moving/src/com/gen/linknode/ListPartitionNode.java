package com.gen.linknode;


/**
 * 将链表按某值划分成左边小，中间相等，右边大的形式
 *
 *解法：将该链表分成三个部分，每一个部分分别有small,equal,big三个头节点，
 * 然后重新将各自部分连接起来。
 * @author Genge
 */
public class ListPartitionNode {

    public static Node partitionNode(Node head, int k){
        if (head == null || k < 0){
            return head;
        }
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;
        Node next = null;
        while (head != null){
            next = head.next;
            if (head.val < k){
                if (sH == null){
                    sH = head;
                    sT = head;
                }else {
                    sT.next = head;
                    sT = sT.next;
                }

            }else if (head.val == k){
                if (eH == null){
                    eH = head;
                    eT = head;
                }else{
                    eT.next = head;
                    eT = eT.next;
                }

            }else {
                if (bH == null){
                    bH = head;
                    bT = head;
                }else {
                    bT.next = head;
                    bT = bT.next;
                }
            }
            head = next;
        }

        if (sH != null){
          sT.next = eH;
          if (eH != null){
              eT.next = bH;
          }
          return sH;
        }else if (eH != null){
            eT.next = bH;
            return eH;
        }else {
            return bH;
        }
    }
}
