package com.gen.sword.offer;

public class NumberOfOne {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        int i = 1;
        int current = 0,after = 0,before = 0;
        while ((n/i) != 0){
            current = (n/i) % 10;
            before = n/(i * 10);
            after = n - (n/i) * i;
            if (current == 0){
                count += before * i;
            }else if (current == 1){
                count += before * i + after + 1;
            }else {
                count += (before + 1) * i;
            }
            i = i * 10;
        }
        return count;
    }
}
