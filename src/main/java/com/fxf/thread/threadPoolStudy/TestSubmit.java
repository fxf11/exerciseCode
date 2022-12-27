package com.fxf.thread.threadPoolStudy;

import java.util.concurrent.*;

/**
 * @Classname TestSubmit
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/2/20 15:40
 * @Created by 饭小范
 */
public class TestSubmit {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Future<String> submit = pool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("running");
                Thread.sleep(1000);
                return "ok";
            }
        });

        System.out.println(submit.get());
    }
}
