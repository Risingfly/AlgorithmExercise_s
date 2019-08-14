package com.gen.nk;

import java.util.HashMap;
import java.util.Scanner;

public class PddTest5 {
//    private static HashMap<String,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
//        while (read.hasNext()){
            int hp = read.nextInt();
            int normal = read.nextInt();
            int buffed = read.nextInt();
            int count = 0;
            if (buffed > normal * 2){
                while (hp > normal){
                    hp -= buffed;
                    count += 2;
                }
                if (hp > 0){
                    count += 1;
                }
            }else {
                while (hp > 0){
                    hp -= normal;
                    count++;
                }
            }
            System.out.println(count);
//        }
    }
    private static int solve(int hp,int normalAttack,int buffedAttack,int count){
        if (buffedAttack > normalAttack * 2){
            while (hp > normalAttack){
                hp -= buffedAttack;
                count += 2;
            }
            if (hp > 0){
                count++;
            }
        }else if (buffedAttack <= normalAttack * 2){
            while (hp > 0){
                hp -= normalAttack;
                count++;
            }
        }
        return 0;
    }
//    private static int process(int hp,int normalAttack,int buffedAttack,int isBuffed,int cur){
//        String str = isBuffed+"_"+hp;
//        if (map.containsKey(str)){
//            return map.get(str);
//        }
//        if (hp < 1){
//            map.put(str,cur);
//            return cur;
//        }
//        int res = 0;
//        if (isBuffed == 1){
//            res = process(hp - buffedAttack,normalAttack,buffedAttack,0,cur + 1);
//        }else {
//            res = Math.min(process(hp -buffedAttack,normalAttack,buffedAttack,0,cur + 1),
//                    process(hp - buffedAttack,normalAttack,buffedAttack,1,cur + 1));
//        }
//        map.put(str,res);
//        return res;
//    }
}
