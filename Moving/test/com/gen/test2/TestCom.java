package com.gen.test2;

import java.util.ArrayList;
import java.util.List;

public class TestCom {
    public static void main(String[] args) {
        TestCom com = new TestCom();
        int[] arr = {2,3,6,7};
        System.out.println(com.combinationSum2(arr,7));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtracking(new ArrayList<>(), combinations, 0, target, candidates);
        return combinations;
    }

    private void backtracking(List<Integer> tempCombination, List<List<Integer>> combinations,
                              int start, int target, final int[] candidates) {

        if (target == 0) {
            combinations.add(new ArrayList<>(tempCombination));
//            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                tempCombination.add(candidates[i]);
                backtracking(tempCombination, combinations, i, target - candidates[i], candidates);
                tempCombination.remove(tempCombination.size() - 1);
            }
        }
    }
    public List<List<Integer>> combinationSum1(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        // Arrays.sort(nums);
        backtrack1(res,new ArrayList<>(),nums,target,0);
        return res;
    }
    private void backtrack1(List<List<Integer>> res,List<Integer> tmp,int[] nums,int remain,int start){
        if (remain < 0){
            return;
        }else if (remain == 0){
            res.add(new ArrayList<>(tmp));
        }else {
            for (int i = start; i < nums.length; i++) {
                tmp.add(nums[i]);
                backtrack1(res,tmp,nums,remain - nums[i],i);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }
        backtracking(res,new ArrayList<>(),nums,target,0);
        return res;
    }
    private void backtracking(List<List<Integer>> res,List<Integer> tmp,int[] nums,int remain,int start){
        if (remain < 0){
            return;
        }
        if (remain == 0){
            res.add(new ArrayList<>(tmp));
        }
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtracking(res,tmp,nums,remain - nums[i],i);
            tmp.remove(tmp.size() - 1);
        }
    }
}
