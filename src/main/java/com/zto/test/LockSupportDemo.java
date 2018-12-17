package com.zto.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {
    public static void main(String[] args) throws InterruptedException {
        LockSupportTest t1 = new LockSupportTest("t1");
        LockSupportTest t2 = new LockSupportTest("t2");
        t1.start();
        Thread.sleep(1000);
        t2.start();
        LockSupport.unpark(t2);
        Thread.sleep(1000);
        LockSupport.unpark(t1);
        System.out.println(LockSupportTest.list.toString());


    }

}

class LockSupportTest extends Thread{
    public static List list = new ArrayList();
    public LockSupportTest(String name) {
        super.setName(name);
    }

    @Override
    public void run() {
        System.out.println("线程开始了"+this.getName());
        System.out.println("线程阻塞了"+this.getName());
        list.add(this.getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.park();
        System.out.println("线程畅通了"+this.getName());

    }
}
