package com.gen.sword.offer;

import java.util.ArrayList;

public class ReOrderArray {
    public void reOrderArray(int [] array) {
        if (array == null || array.length == 0){
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
//        int[] arr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1){
                list.add(array[i]);
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0){
                list.add(array[i]);
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
//        array = arr;
    }
}
