package com.gen.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题:216
 * @author Genge
 */
public class CombinationSumIII {
    public static void main(String[] args) {
        CombinationSumIII com = new CombinationSumIII();
        com.combinationSum3(3,7);
        System.out.println(com.combinationSum3(3,7));
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k < 0 || k > n){
            return res;
        }
        backtracking(res,new ArrayList<>(),k,1,n);
        return res;
    }

    /**
     * k是结果的长度,remain是每次搜索后结果减少最后的值,start是搜索起始
     * @param res
     * @param tmp
     * @param k
     * @param start
     * @param remain
     */
    private void backtracking(List<List<Integer>> res,List<Integer> tmp,int k,int start,int remain){
        if (tmp.size() == k && remain == 0){
            res.add(new ArrayList<>(tmp));
            return;
        }
//        i 是可以搜索的范围
        for (int i = start; i <= 9; i++) {
            tmp.add(i);
            backtracking(res,tmp,k,i + 1,remain - i);
            tmp.remove(tmp.size() - 1);
        }
    }
}
