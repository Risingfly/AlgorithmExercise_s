package com.gen.sword.offer;

/***
 *
 * 问题：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 * @author Genge
 */
public class PostTraverse {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null){
            return true;
        }
        if (sequence.length == 0){
            return false;
        }
        if (sequence.length == 1){
            return true;
        }
        return judge(sequence,0,sequence.length - 1);
    }

    public boolean judge(int[] seq,int start,int end){
//          递归出口
        if (start >= end){
            return true;
        }
        int i = start;
//        寻找到第一个右子树的节点（左右分界点）
        while (seq[i] < seq[end]){
            i++;
        }
//        右子树中有一个不小于根节点的即返回false
        for (int j = i; j < end; j++) {
            if (seq[j] < seq[end]){
                return false;
            }
        }
//        递归左右子数组，每个子数组的最后一个节点为根节点
        return judge(seq,start,i - 1) && judge(seq,i,end - 1);
    }
}
