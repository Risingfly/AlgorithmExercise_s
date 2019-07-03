package com.gen.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题：22
 * @author Genge
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(res,sb,0,0,n);
        return res;
    }
    private void backtrack(List<String> res, StringBuilder sb, int open, int close, int n){
        if (open == n && close == n){
            res.add(sb.toString());
            return;
        }
//        核心思想，‘）’右括号在添加之前必须小于左括号的个数
        if (open < n){
            sb.append('(');
            backtrack(res,sb,open + 1,close,n);
            sb.setLength(sb.length() - 1);
        }
        if (close < open){
            sb.append(')');
            backtrack(res,sb,open,close + 1,n);
            sb.setLength(sb.length() - 1);
        }
    }
}
