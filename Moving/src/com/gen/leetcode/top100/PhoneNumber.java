package com.gen.leetcode.top100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PhoneNumber {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> queue = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return queue;
        }
        char[] dc = digits.toCharArray();
        String[] buttons = new String[]{"0","1","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        queue.offer("");
        for (int i = 0; i < dc.length; i++) {
            char[] letters = buttons[Character.getNumericValue(dc[i])].toCharArray();
            while (queue.peek().length() == i){
                String row = queue.poll();
                for (char c: letters) {
                    queue.offer(row + c);
                }
            }
        }
        return queue;
    }
    public List<String> letterCombinations2(String digits) {
        List<String> result = new ArrayList<>();
        String[][] map={{},{},{"a","c","b"},{"d","e","f"},{"g","h","i"},{"j","k","l"},{"m","n","o"},{"p","q","r","s"},,{"t","u","v"},{"w","x","y","z"}};
        String single = "";
        if (digits == null || digits.length() == 0){
            return result;
        }
        helper(result,single,digits,map,0);
        return result;
    }
    private void helper(List<String> result,String single,String digits,String[][] map,int start){
       if (start >= digits.length()){
           result.add(single);
           return;
       }
       int index = digits.charAt(start) - '0';
       String[] current = map[index];
        for (int i = 0; i < current.length; i++) {
            single = single + current[i];
            helper(result,single,digits,map,start + 1);
            single = single.substring(0,single.length() - 1);
        }
    }
}
