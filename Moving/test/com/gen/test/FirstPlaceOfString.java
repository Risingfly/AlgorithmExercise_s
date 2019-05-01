package com.gen.test;

public class FirstPlaceOfString {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0){
            return -1;
        }
        int[] map = new int[256];
        for (int i = 0; i < str.length(); i++) {
            map[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (map[str.charAt(i)] == 1){
                return i;
            }
        }
        return -1;
    }
}
