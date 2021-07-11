package com.fxf.thread;

import java.util.Calendar;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 使用线程池创建线程
 * @date 2021/7/11 16:44
 */
public class ThreadPool {

    public static void main(String[] args) {
        

        //提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        System.out.println(service.getClass());
        //适合用于Runable
        //执行指定的线程的操作，需要提供实现Runable接口或者Callable接口的实现类的对象
        service.execute(new NumberThread());
//        service.submit()//适合用于Callable
        service.shutdown();
    }
}

class NumberThread implements Runnable{
    @Override
    public void run() {
        int len = 100;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}
