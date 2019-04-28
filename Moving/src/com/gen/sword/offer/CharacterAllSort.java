package com.gen.sword.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 问题：输入一个字符串,按字典序打印出该字符串中字符的所有排列
 * @author Genge
 */
public class CharacterAllSort {
    public ArrayList<String> Permutation(String str) {
        List<String> res = new ArrayList<>();
        if (str != null && str.length() > 0){
            PermutationHelper(str.toCharArray(),0,res);
            Collections.sort(res);
        }
        return (ArrayList<String>) res;
    }
    public void PermutationHelper(char[] cs,int i,List<String> list){
        if (i == cs.length - 1){
            String val = String.valueOf(cs);
            if (!list.contains(val)){
                list.add(val);
            }
        }else {
            for (int j = i; j < cs.length; j++) {
                swap(cs,i,j);
                PermutationHelper(cs,i + 1,list);
                swap(cs,i,j);
            }
        }
    }

    public void swap(char[]cs,int i,int j){
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }
}
