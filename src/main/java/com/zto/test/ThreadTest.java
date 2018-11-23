package com.zto.test;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {

                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("线程停止");
                        break;
                    }
                    System.out.println(1);
                }
            }
        };
        Thread t1 = new Thread(r1);
        t1.start();
        Thread.sleep(2000);
        t1.interrupt();

        System.out.println(2);


    }
}
