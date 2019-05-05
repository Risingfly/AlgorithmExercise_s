package com.gen.test;

import com.gen.sword.offer.TreeNode;

public class TreeTest {
    public int TreeDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return left < right ? right + 1 : left + 1;
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null){
            return true;
        }
        if (Math.abs(depath(root.left) - depath(root.right)) < 1){
            return true;
        }else {
            return false;
        }
    }

    public int depath(TreeNode node){
        if (node == null){
            return 0;
        }
        int left = depath(node.left);
        int right = depath(node.right);
        return left > right ? left + 1 : right + 1;
    }

}
