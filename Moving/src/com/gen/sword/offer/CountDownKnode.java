package com.gen.sword.offer;

public class CountDownKnode {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k <= 0){
            return head;
        }
        ListNode cur = head;
        while (cur != null){
            k--;
            cur = cur.next;
        }
        if (k > 0){
            return  null;
        }
//        if (k == 0){
//            return head;
//        }
        while (k != 0){
            k++;
            head = head.next;
        }
        return head;
    }
    public ListNode ReverseList(ListNode head) {
        ListNode next = null;
        ListNode pre = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2){
        boolean res = false;
        if (root1 != null && root2 != null){
            if (root1.val == root2.val){
                res = DoHasSubtree(root1,root2);
            }
            if (!res){
                HasSubtree(root1.left,root2);
            }
            if (!res){
                HasSubtree(root1.right,root2);
            }
        }

        return res;
    }
    public boolean DoHasSubtree(TreeNode root1,TreeNode root2){
        if (root1 == null && root2 != null){
            return false;
        }
        if (root2 == null){
            return true;
        }
        if (root1.val != root2.val){
            return false;
        }
        return DoHasSubtree(root1.left,root2.left) && DoHasSubtree(root1.right,root2.right);
    }
}
