package com.gen.sword.offer;

public class RectanglePose {
    public int RectCover(int target) {
        if (target <= 1){
            return 1;
        }else  if (target == 2){
            return 2;
        }else {
            return RectCover(target - 1) + RectCover(target - 2);
        }
    }
}
