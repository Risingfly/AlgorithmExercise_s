package com.gen.sword.offer;

/***
 *
 * 问题：将二叉搜索树转换成排序的双向链表
 * @author Genge
 */
public class BinaryTreeToLinkNode {
    TreeNode head = null;
    TreeNode realHead = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertSub(pRootOfTree);
        return realHead;
    }

    public void ConvertSub(TreeNode root){
        if (root == null){
            return;
        }
        ConvertSub(root.left);
        if (head == null){
            head = root;
            realHead = root;
        }else {
//            构成双向链表
            head.right = root;
            root.left = head;
            head = root;
        }
        ConvertSub(root.left);
    }
}
