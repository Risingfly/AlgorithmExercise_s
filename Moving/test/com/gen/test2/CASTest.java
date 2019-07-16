package com.gen.test2;

public class CASTest {
    private volatile int val = 1;
    public int getVal(){
        return val;
    }
    public boolean compareAndSet(int expect,int update){
        synchronized (this){
            if (expect == val){
                val = update;
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        CASTest lock = new CASTest();
        Cas1 cas1 = new Cas1(lock);
        cas1.setName("cas1");
        Cas2 cas2 = new Cas2(lock);
        cas2.setName("cas2");

        cas1.start();
        cas2.start();
    }
}
class Cas1 extends Thread{
    private CASTest casLock;
    public Cas1(CASTest casLock){
        this.casLock = casLock;
    }
    @Override
    public void run() {
        for (;;){
            if (casLock.compareAndSet(0,100)){
                System.out.println(Thread.currentThread().getName()+"修改成功,value= "+casLock.getVal());
                break;
            }
        }
    }
}
class Cas2 extends Thread{
    private CASTest casLock;
    public Cas2(CASTest casLock){
        this.casLock = casLock;
    }
    @Override
    public void run() {
        for (;;){
            if (casLock.compareAndSet(1,1000)){
                System.out.println(Thread.currentThread().getName()+"修改成功,value= "+casLock.getVal());
                break;
            }
        }
    }
}