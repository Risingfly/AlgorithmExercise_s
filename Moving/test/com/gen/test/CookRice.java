package com.gen.test;

public class CookRice extends Thread{
    private Rice rice;
    public CookRice(Rice rice){
        this.rice = rice;
    }

    @Override
    public void run() {
        Rice.lock.lock();
//        synchronized (rice){

        Rice.condition.signal();

        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("I am cook , I like cook Rice!");
                Rice.cook();
                Rice.sleeping(1000);

            }


        } finally {
            Rice.lock.unlock();
        }

//            Rice.sleeping(2000);
//            rice.notify();
//        }
//        try {
//            rice.wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
