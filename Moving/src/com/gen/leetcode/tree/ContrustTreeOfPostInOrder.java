package com.gen.leetcode.tree;

import java.util.HashMap;

/**
 * 问题:106
 * @author Genge
 */
public class ContrustTreeOfPostInOrder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null){
            return null;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return buildTree(inorder,0,inorder.length - 1,postorder,0,postorder.length -1,map);
    }
    public TreeNode buildTree(int[] inorder,int ni,int nj,int[] postorder,
                              int pi,int pj,HashMap<Integer,Integer> map){
        if (pi > pj){
            return null;
        }
        TreeNode head = new TreeNode(postorder[pj]);
        int index = map.get(postorder[pj]);
        head.left = buildTree(inorder,ni,index -1,postorder,pi,pi + index - ni - 1,
                map);
        head.right = buildTree(inorder,index + 1,nj,postorder,pi + index - ni,
                pj - 1,map);
        return head;
    }
}
