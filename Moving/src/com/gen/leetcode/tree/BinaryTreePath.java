package com.gen.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题:257
 * @author Genge
 */
public class BinaryTreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res,root,sb);
        return res;
    }
    private void dfs(List<String> res,TreeNode root,StringBuilder sb){
        if (root == null){
            return;
        }
        int len = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right == null){
            res.add(sb.toString());
        }else {
            sb.append("->");
            dfs(res,root.left,sb);
            dfs(res, root.right, sb);
        }
        sb.setLength(len);
    }
}
