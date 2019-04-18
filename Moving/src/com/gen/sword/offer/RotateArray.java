package com.gen.sword.offer;

public class RotateArray {
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (min < array[i]){
                min = array[i];
            }
        }
        return min;
    }
}
