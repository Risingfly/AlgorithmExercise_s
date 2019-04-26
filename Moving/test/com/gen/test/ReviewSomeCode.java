package com.gen.test;

import com.gen.sword.offer.TreeNode;

public class ReviewSomeCode {
    TreeNode head = null;
    TreeNode realHead = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertNode(head);
        return realHead;
    }
    public void ConvertNode(TreeNode node){
        if (node == null){
            return;
        }
        ConvertNode(node.left);
        if (head == null){
            head = node;
            realHead = node;
        }else {
            head.right = node;
            node.left = head;
            head = node;
        }
        ConvertNode(node.right);
    }
}
