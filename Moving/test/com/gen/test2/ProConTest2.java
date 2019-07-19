package com.gen.test2;

public class ProConTest2 {
    private static volatile int count;
    private final Object lock = new Object();
    public void put(){
        synchronized (lock){
            if (count >= 10){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count++;
            System.out.println("Pro--"+Thread.currentThread().getName()+"pro : "+count);
            lock.notifyAll();
        }
    }
    public void take(){
        synchronized (lock){
            if (count <= 0){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count--;
            System.out.println("Con--"+Thread.currentThread().getName()+"con : "+count);
            lock.notifyAll();
        }
    }

    public static void main(String[] args) {
        ProConTest2 proConTest2 = new ProConTest2();
        Con1 con1 = new Con1(proConTest2);
//        Con1 con2 = new Con1(proConTest2);
//        Con1 con3 = new Con1(proConTest2);
//        Con1 con4 = new Con1(proConTest2);
        Pro1 pro1 = new Pro1(proConTest2);
        con1.start();
        pro1.start();
//        Pro1 pro2 = new Pro1(proConTest2);
//        Pro1 pro3 = new Pro1(proConTest2);
//        con1.start();
//        con2.start();
//        con3.start();
//        con4.start();
//        pro1.start();
////        pro2.start();
////        pro3.start();
    }
}
class Con1 extends Thread{
    private ProConTest2 proConTest2;
    public Con1(ProConTest2 proConTest2){
        this.proConTest2 = proConTest2;
    }
    @Override
    public void run() {
        for (;;){
            UtilSleep.sleep(1000);
            proConTest2.take();
        }
    }
}
class Pro1 extends Thread{
    private ProConTest2 proConTest2;
    public Pro1(ProConTest2 proConTest2){
        this.proConTest2 = proConTest2;
    }

    @Override
    public void run() {
        for (;;){
            UtilSleep.sleep(1000);
            proConTest2.put();
        }
    }
}