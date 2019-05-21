package com.gen.test;

import java.util.concurrent.*;

public class TestFuture {
    public static void sleep(int mills){
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void testFuture()throws Exception{
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> future = service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                sleep(1000);
//                throw new IllegalArgumentException("异常");
                return 1;
            }
        });
        service.shutdown();

        try {
            System.out.println(future.get(100,TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)throws Exception {
        testFuture();
    }
}
