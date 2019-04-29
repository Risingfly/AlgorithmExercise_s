package com.gen.sword.offer;

public class OverHalfNum {

    public int MoreThanHalfNum_Solution(int [] array) {
        int count = 1;
        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            if (count == 0){
                res = array[i];
                count = 1;
            }else if (res == array[i]){
                count++;
            }else {
                count--;
            }
        }

        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (res == array[i]){
                count++;
            }
        }
        if (count < array.length/2 ){
            return 0;
        }else {
            return res;
        }
    }
}
