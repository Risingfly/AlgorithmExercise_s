package com.gen.test2;

import java.util.concurrent.*;

public class CallableTest implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        Thread.sleep(3000);
        System.out.println("66666666");
        return 666;
    }

    public static void main(String[] args)throws Exception {
        CallableTest call = new CallableTest();
        FutureTask<Integer> ft = new FutureTask<>(call);
        Thread t = new Thread(ft);
        t.start();
        t.interrupt();
        System.out.println("result = "+ft.get());
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        for (int i = 0; i < 5; i++) {
//            executorService.submit(call);
//        }
//        executorService.shutdownNow();
    }
}
