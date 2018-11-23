package com.zto.test;

public class IntegerTest implements Runnable {
    /**
     * Integer进行++操作其实是; 会new一个对象把计算后的值填进去;而我们锁的对象一直在变;所以无法保证线程安全
     *

     */
    static Integer i = 0;

    static IntegerTest intance = new IntegerTest();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new IntegerTest());
        Thread t2 = new Thread(new IntegerTest());
        t1.start();
        t2.start();
        Thread.sleep(1000);
        System.out.println(i);
    }

    @Override
    public void run() {

        for (int j = 0; j < 1000; j++) {
            synchronized (intance) {
                i++;
            }
        }

    }
}
