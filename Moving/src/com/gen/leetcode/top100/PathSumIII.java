package com.gen.leetcode.top100;

import com.gen.leetcode.tree.TreeNode;

/**
 * 问题：437
 * 思路：从该树的任意个节点都需要遍历是否有路径
 * pathSumGet函数遍历以该节点为头节点的路径
 * pathSum函数遍历头节点，然后递归左右子树
 *
 * @author Genge
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum){
        if (root == null){
            return 0;
        }
//        获取头节点的路径，再递归左右子树
        return pathSumGet(root,sum) + pathSumGet(root.left,sum) + pathSumGet(root.right,sum);
    }
    public int pathSumGet(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        return (root.val == sum ? 1 : 0) + pathSumGet(root.left,sum - root.val) + pathSumGet(root.right,sum - root.val);
    }

//    public int pathSum(TreeNode root, int sum) {
//        if (root == null) return 0;
//        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
//    }
//
//    private int pathSumFrom(TreeNode node, int sum) {
//        if (node == null) return 0;
//        return (node.val == sum ? 1 : 0)
//                + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
//    }
}
