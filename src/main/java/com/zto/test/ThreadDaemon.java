package com.zto.test;

public class ThreadDaemon {
    public static void main(String[] args) throws InterruptedException {
        DaemonT t = new DaemonT();
        t.setDaemon(true);
        t.start();
        Thread.sleep(1000);
    }
}

class DaemonT extends Thread{
    @Override
    public void run() {
        while (true){
            System.out.println("I am alive");
        }
    }
}
