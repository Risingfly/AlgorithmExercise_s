package com.gen.sword.offer;

/***
 *
 * 问题：给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）
 * 中，按结点数值大小顺序第三小结点的值为4。
 * @author Genge
 */
public class TheKNode {
    int index = 0;
    TreeNode KthNode(TreeNode pRoot, int k){

        if (pRoot != null){
//            递归左子树
            TreeNode node = KthNode(pRoot.left,k);
            if (node != null){
                return node;
            }
//            处理当前层
            index++;
            if (index == k){
                return pRoot;
            }
//            递归右子树
            node = KthNode(pRoot.right,k);
            if (node != null){
                return node;
            }
        }
        return null;
    }
}
