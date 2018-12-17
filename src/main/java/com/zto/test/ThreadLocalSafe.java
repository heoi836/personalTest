package com.zto.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalSafe implements Runnable{
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    ThreadLocal<SimpleDateFormat> x = new ThreadLocal<SimpleDateFormat>();
    int j = 0;

    public ThreadLocalSafe(int j) {
        this.j = j;
    }

    @Override
    public void run() {
        try {
            x.set(new SimpleDateFormat("yyyy-MM-dd"));
            System.out.println(x.get().parse("2018-11-10"+ j).toLocaleString()+j+"次");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i =0; i<1000;i++){
            pool.execute(new ThreadLocalSafe(i));

        }
    }
}
