package com.gen.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题：46
 * @author Genge
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null){
            return res;
        }
        perm(res,new ArrayList<>(),nums);
        return res;
    }
    private void perm(List<List<Integer>> res, List<Integer> tmp, int[] nums){
        if(tmp.size() == nums.length){
            res.add(new ArrayList<>(tmp));
        }else{
            for(int i = 0; i < nums.length; i++){
                if(tmp.contains(nums[i])){
                    continue;
                }
                tmp.add(nums[i]);
                perm(res,tmp,nums);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
