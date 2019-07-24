package com.gen.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题:77
 * @author Genge
 */
public class Combinations {
    public static void main(String[] args) {
//        combine(4,2);
        Combinations com = new Combinations();
        System.out.println(com.combine(4,2));
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res,new ArrayList<>(),1,n,k);
        return res;
    }
    private void backtracking(List<List<Integer>> res,List<Integer> tmp,int start,int n,int k){
        if (k == 0){
            res.add(new ArrayList<>(tmp));
        }
        for (int i = start; i <= n; i++) {
            tmp.add(i);
            backtracking(res,tmp,i + 1,n,k - 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
