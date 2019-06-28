package com.gen.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题：131
 * @author Genge
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res,new ArrayList<>(),s,0);
        return res;
    }
    private void backtrack(List<List<String>> res,List<String> tmp,String s,int start){
        if(start == s.length()){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = start; i < s.length(); i++){
            if (isPalindrome(s,start,i)){
                tmp.add(s.substring(start,i + 1));
                backtrack(res,tmp,s,i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String str,int low,int high){
        while (low < high){
            if (str.charAt(low++) != str.charAt(high--)){
                return false;
            }
        }
        return true;
    }
}
