package com.gen.test2;

import java.util.ArrayList;
import java.util.List;

public class TestSubsets {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        TestSubsets subsets = new TestSubsets();
        System.out.println(subsets.subsets(arr));
    }
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }
        backtracking(res,new ArrayList<>(),nums,0);
        return res;
    }
    private void backtracking(List<List<Integer>> res,List<Integer> tmp,int[] nums,int start){
        if (start > nums.length){
            return;
        }
        res.add(new ArrayList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtracking(res,tmp,nums,i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
