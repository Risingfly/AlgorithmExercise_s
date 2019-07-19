package com.gen.test2;

import java.util.concurrent.ArrayBlockingQueue;

public class QueConProTest {
    private static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
    static class Con extends Thread{
        @Override
        public void run() {
            try {
                for (;;){
                    UtilSleep.sleep(1000);
                    String str = queue.take();
                    System.out.println("get string: "+str);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class Pro extends Thread{
        @Override
        public void run() {
            String str = "根哥真牛逼!6666666";
            for (int i = 0; i < str.length(); i++) {
                try {
                    UtilSleep.sleep(1000);
                    queue.put(str.substring(i,i + 1));
//                    System.out.println("pro string: "+String.valueOf(str.charAt(i)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Con con = new Con();
        Pro pro = new Pro();
        con.start();
        pro.start();
    }
}
