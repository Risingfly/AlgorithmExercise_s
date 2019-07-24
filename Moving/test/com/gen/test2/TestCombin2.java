package com.gen.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCombin2 {
    public static void main(String[] args) {
        TestCombin2 testCombin2 = new TestCombin2();
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(testCombin2.combinationSum2(arr,8));
    }
    private List<List<Integer>> combinationSum2(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0){
            return res;
        }
        Arrays.sort(candidates);
        backtracking(res,new ArrayList<>(),candidates,0,target);
        return res;
    }
    private void backtracking(List<List<Integer>> res,List<Integer> tmp,int[] nums,int start,int target){
        if (target < 0){
            return;
        }
        if (target == 0){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]){
                continue;
            }
            tmp.add(nums[i]);
            backtracking(res,tmp,nums,i + 1,target - nums[target]);
            tmp.remove(tmp.size() - 1);
        }

    }
}
