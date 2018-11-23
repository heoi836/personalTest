package com.zto.test;

import java.util.ArrayList;

public class ArraysListTest {


}

/**
 * 并发下的ArrayList
 */
class A implements Runnable{
    static ArrayList list = new ArrayList(2000);
    @Override
    public void run() {
        for (int i = 0;i< 1000; i++ ){
            list.add(i);
        }
        System.out.println(list.size());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new A());
        Thread t2 = new Thread(new A());
        t1.start();
        t2.start();
        Thread.sleep(1000);
        System.out.println(list.size());


    }
}

