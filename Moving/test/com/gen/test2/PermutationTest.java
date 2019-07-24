package com.gen.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationTest {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,4};
        permute2(arr);
        System.out.println(permute2(arr));
    }
    public static List<List<Integer>> permute2(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        permute2(nums,res,new ArrayList<>());
        return res;
    }
    private static void permute2(int[] nums,List<List<Integer>> res,List<Integer> tmp){
        if (tmp.size() == nums.length){
            res.add(new ArrayList<>(tmp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            tmp.add(nums[i]);
            permute2(nums,res,tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }
        permute(nums,res,new ArrayList<>());
        return res;
    }
    private static void permute(int[] nums,List<List<Integer>> res,List<Integer> tmp){
        if (tmp.size() == nums.length){
            res.add(new ArrayList<>(tmp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (tmp.contains(nums[i])){
                continue;
            }
            tmp.add(nums[i]);
            permute(nums,res,tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
