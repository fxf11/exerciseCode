package com.fxf.thread.threadPoolStudy;

import java.time.Instant;
import java.util.concurrent.*;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2021/8/9 13:51
 * @Version 1.0
 */
public class ThreadPoolExcutorDemo1 {

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("CurrentThread name:" + Thread.currentThread().getName() + "date：" + Instant.now());
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(5,TimeUnit.SECONDS);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Finished all threads");

    }

    /**
     *打印线程池的状态
     * @param threadPool 线程池对象
     */
    public static void printThreadPoolStatus(ThreadPoolExecutor threadPool){
//        new ScheduledThreadPoolExecutor(1,createThreadFactory("print-images/thread-pool-status", false));
    }
}
