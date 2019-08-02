package com.gen.test3;

import java.util.List;

public class TestNk {
    int getLongestLength(List<Integer> array){
        //   TODO
        int sum = 0, max = -1;
        int count = 0;
        for (int i = 0; i < array.size(); i++) {
            for (int j = i; j < array.size(); j++) {
                sum += array.get(j);
                if (sum == 0){
                    count = j - i + 1;
                    max = count > max ? count : max;
                }
            }
        }
        return max;
    }
}
