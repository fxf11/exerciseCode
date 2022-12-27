package com.fxf.thread.threadPoolStudy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname TestThreadpoolExecutors
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/2/20 15:04
 * @Created by 饭小范
 */
public class TestThreadpoolExecutors {

    public static void main(String[] args) {
//        ExecutorService pool = Executors.newFixedThreadPool(2); 
        //线程工厂实现
        ExecutorService pool = Executors.newFixedThreadPool(2, new ThreadFactory() {

            private AtomicInteger t = new AtomicInteger(1);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"mypool_t" + t.getAndIncrement());
            }
        });

        pool.execute(()->{
            System.out.println("1");
        });
        pool.execute(()->{
            System.out.println("2");
        });
        pool.execute(()->{
            System.out.println("3");
        });

    }

}
