package com.gen.test2;

import java.util.ArrayList;
import java.util.List;

public class TestPermu {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,4};
        System.out.println(permute(arr));
    }
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null){
            return res;
        }
        boolean[] visited = new boolean[nums.length];
        List<Integer> tmp = new ArrayList<>();
        backtracking(res,tmp,visited,nums);
        return res;
    }
    private static void backtracking(List<List<Integer>> res,List<Integer> tmp,boolean[] visited,int[] nums){
        if (tmp.size() == nums.length){
            res.add(new ArrayList<>(tmp));
        }
        for (int i = 0; i < nums.length; i++) {
            if ( i!= 0 && !visited[i - 1] && nums[i] == nums[i - 1]){
                continue;
            }
            if (visited[i]){
                continue;
            }
            visited[i] = true;
            tmp.add(nums[i]);
            backtracking(res,tmp,visited,nums);
            tmp.remove(tmp.size() - 1);
            visited[i] = false;
        }
    }
}
