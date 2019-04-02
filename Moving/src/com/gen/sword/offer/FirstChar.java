package com.gen.sword.offer;

/**
 * 问题：字符串中第一个只出现一次的字符
 * @author Genge
 */
public class FirstChar {
    public int FirstNotRepeatingChar(String str) {
//        数组从0开始，因此最后一个值必将比原值大1
//      ASCII  大写字母 A - Z --> [65,90] 小写字母 a - z --> [97,122] 小写 = 大写 + 32
        int[] map = new int['z' + 1];
        char[] chars = str.toCharArray();
//        存储每个字符出现的次数
        for (int i = 0; i < chars.length; i++) {
            map[(int) chars[i]]++;
        }
//        再次从0开始即可找到第一个出现一次的字符
        for (int i = 0; i < chars.length; i++) {
            if (map[(int) chars[i]] == 1){
                return i;
            }
        }
        return -1;
    }
}
