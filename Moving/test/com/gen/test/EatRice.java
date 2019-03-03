package com.gen.test;

public class EatRice extends Thread{
    private Rice rice;
    public EatRice(Rice rice){
        this.rice = rice;
    }


    @Override
    public void run() {
//        synchronized (rice){
        Rice.lock.lock();
        try {
            for (;;) {
                System.out.println("I want to eat rice~~~");
                Rice.eat();
                try {
                    Rice.condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Rice.sleeping(1000);

            }

        } finally {
            Rice.lock.unlock();
        }
//            try {
//                rice.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            Rice.sleeping(1000);
//        }
//        rice.notify();
    }
}
