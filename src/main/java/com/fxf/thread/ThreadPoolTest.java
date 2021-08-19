package com.fxf.thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2021/8/3 14:08
 * @Version 1.0
 */
public class ThreadPoolTest {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                System.out.println("thread id is：" + Thread.currentThread().getName());

                try {
                    Thread.sleep(1000L);

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            });

        }
    }

    @Test
    public void test(){

        ScheduledExecutorService executors = Executors.newScheduledThreadPool(2);

        //定时调度，每个调度任务会至少等待period的时间，如果任务执行的时间超过period，则等待的时间为任务执行的时间
        executors.scheduleAtFixedRate(() -> {
            try {
                Thread.sleep(5000);
                System.out.println(System.currentTimeMillis() / 100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        },0,2, TimeUnit.SECONDS);

        //定时调度，第二个任务执行的时间 = 第一个任务执行时间 + delay
        executors.scheduleWithFixedDelay(() -> {
            try {
                Thread.sleep(5000);
                System.out.println(System.currentTimeMillis() / 100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        },0,2, TimeUnit.SECONDS);

        //定时调度，延迟delay后执行，且只执行一次
        executors.schedule(() -> System.out.println("5 秒之后执行 schedule"), 5, TimeUnit.SECONDS);

    }

    @Test
    public void test1(){

    }
}
