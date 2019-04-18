package com.gen.sword.offer;

public class Frogs {
    public int JumpFloor(int target) {
        if (target == 1){
            return 1;
        }else if (target == 2){
            return 2;
        }else {
            return JumpFloor(target - 1) + JumpFloor(target - 2);
        }
    }
    public int JumpFloor2(int target){
        if (target == 0){
            return 1;
        }else if (target == 1){
            return 1;
        }else {
            return 2 * JumpFloor2(target - 1);
        }
    }
}
