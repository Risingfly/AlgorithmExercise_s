package com.gen.test2;

import java.util.ArrayList;
import java.util.List;

public class TestPalindrome {
    public static void main(String[] args) {
        String s = "qqb";
        TestPalindrome p = new TestPalindrome();
        System.out.println(p.partition(s));
    }
    public List<List<String>> partition(String s){
        List<List<String>> res = new ArrayList<>();
        if (s == null){
            return res;
        }
        backtracking(res,new ArrayList<>(),s,0);
        return res;
    }
    private void backtracking(List<List<String>> res,List<String> tmp,String s,int start){
        if (start >= s.length()){
            res.add(new ArrayList<>(tmp));
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s,start,i)){
                tmp.add(s.substring(start,i + 1));
                backtracking(res,tmp,s,i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String str,int l,int r){
        while (l < r){
            if (str.charAt(l++) != str.charAt(r--)){
                return false;
            }
        }
        return true;
    }
}
