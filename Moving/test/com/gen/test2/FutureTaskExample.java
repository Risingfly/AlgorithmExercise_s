package com.gen.test2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskExample {
    public static void main(String[] args)throws Exception {
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            StringBuilder str = new StringBuilder();
            @Override
            public String call() throws Exception {
                for (int i = 0; i < 10;i++){
                    str.append("根哥牛逼");
                }
                return str.toString();
            }
        });
        ExecutorService pool = Executors.newScheduledThreadPool(3);
        pool.execute(futureTask);
        UtilSleep.sleep(1000);
        System.out.println(futureTask.get());
    }
}
