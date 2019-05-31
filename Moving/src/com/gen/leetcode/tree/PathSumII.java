package com.gen.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题:113
 * @author Genge
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        pathSum(root,sum,res,cur);
        return res;
    }

    public void pathSum(TreeNode node,int sum,List<List<Integer>> res,List<Integer> cur){
        if (node == null){
            return;
        }
        cur.add(node.val);
        if (node.left == null && node.right == null && node.val == sum){
            res.add(new ArrayList<>(cur));
        }else {
            pathSum(node.left,sum - node.val,res,cur);
            pathSum(node.right,sum - node.val,res,cur);
        }
//        back-tracking
        cur.remove(cur.size() - 1);
    }
}
