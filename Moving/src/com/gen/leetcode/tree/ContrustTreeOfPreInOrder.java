package com.gen.leetcode.tree;

import java.util.HashMap;

/**
 * 问题:105
 * @author Genge
 */
public class ContrustTreeOfPreInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null){
            return null;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return buildTree(preorder,0,preorder.length -1,inorder,0,inorder.length -1,map);
    }
    public TreeNode buildTree(int[] preorder,int pi,int pj,int[] inorder,
                              int ni,int nj,HashMap<Integer,Integer> map){
        if (pi > pj){
            return null;
        }
        TreeNode head = new TreeNode(preorder[pi]);
        int index = map.get(preorder[pi]);
        head.left = buildTree(preorder,pi + 1,pi + index - ni,
                inorder,ni,index - 1,map);
        head.right = buildTree(preorder,pi + index - ni + 1,pj,
                inorder,index + 1,nj,map);
        return head;
    }
}
