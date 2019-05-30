package com.gen.leetcode.tree;

/**
 * 问题:108
 * @author Genge
 */
public class ConvertedArrayToTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        return converted(nums,0,nums.length - 1);
    }
    public TreeNode converted(int[] nums, int left, int right){
        if (left > right){
            return null;
        }
        int l = left;
        int r = right;
        int mid = (l + r) >> 1;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = converted(nums,l,mid - 1);
        node.right = converted(nums,mid + 1,r);
        return node;
    }
}
