package com.fxf.thread.threadPoolStudy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Classname TestShowDown
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/2/20 16:02
 * @Created by 饭小范
 */
public class TestShowDown {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Future<Integer> result1 = pool.submit(()->{
            System.out.println("task 1 running...");
            Thread.sleep(1000);
            System.out.println("task 1 finish...");
            return 1;
        });
        Future<Integer> result2 = pool.submit(()->{
            System.out.println("task 2 running...");
            Thread.sleep(1000);
            System.out.println("task 2finish...");
            return 2;
        });
        Future<Integer> result3 = pool.submit(()->{
            System.out.println("task 3 running...");
            Thread.sleep(1000);
            System.out.println("task 3 finish...");
            return 3;
        });

        System.out.println("shutdown");
        pool.shutdownNow();

    }
}

