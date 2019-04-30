package com.gen.sword.offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 问题：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个
 * @author Genge
 */
public class SortOfArrays {
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1 + o2;
                String str2 = o2 + o1;
                return str1.compareTo(str2);
            }
        });
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }
}
