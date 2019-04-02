package com.gen.sword.offer;

public class Joker {
    public boolean isContinuous(int [] numbers) {
//        顺子数最多为5
        int N = 5;
        if (numbers.length != N){
            return false;
        }
        int max = -1;
        int min = 14;
        int[] map = new int[14];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0){
                continue;
            }
            if (numbers[i] < min){
                min = numbers[i];
            }
            if (numbers[i] > max){
                max = numbers[i];
            }
        }
        if (max - min >= N){
            return false;
        }
        for (int i = 0; i < numbers.length; i++) {
            map[numbers[i]]++;
        }
        for (int i = 1; i < map.length; i++) {
            if (map[i] > 1){
                return false;
            }
        }
        return true;
    }
}
