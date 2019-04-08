package com.gen.sword.offer;

import java.util.HashMap;

/**
 *
 * 问题：根据前序和中序遍历重建二叉树
 * @author Genge
 */
public class ReconBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0){
            return new TreeNode(0);
        }
//        将中序数组的值和数组下标关联起来
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i],i);
        }

        return recon(pre,0,pre.length - 1,in,0,in.length - 1,map);
    }

    public TreeNode recon(int[] pre, int pi, int pj, int[] in, int ni, int nj, HashMap<Integer,Integer> map){
//    递归出口
        if (pi > pj){
            return null;
        }
        TreeNode head = new TreeNode(pre[pi]);
//    前序遍历的第一个节点为所有子树头节点
        int index = map.get(pre[pi]);
        head.left = recon(pre,pi + 1,pi + index - ni,in,ni,index - 1,map);
        head.right = recon(pre,pi + index - ni + 1,pj,in,index + 1,nj,map);
        return head;
    }
}
