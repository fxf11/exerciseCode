package com.fxf.thread.threadPoolStudy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 *
 * 模拟了 10 个任务，我们配置的核心线程数为 5 、等待队列容量为 100 ，所以每次只可能存在 5 个任务同时执行，
 * 剩下的 5 个任务会被放到等待队列中去。当前的5个任务中如果有任务被执行完了，线程池就会去拿新的任务执行。
 *
 * @Description TODO ThreadPoolExecutorDemo
 * @Author fxf
 * @Date 2021/8/9 9:54
 * @Version 1.0
 */
public class ThreadPoolExecutorDemo {

    private static final int CODE_POOL_SIZE = 5;// 核心线程数为 5。
    private static final int MAX_POOL_SIZE = 10;//最大线程数 10
    private static final int QUEUE_CAPACITY = 100;//等待队列容量为 100
    private static final Long KEEP_ALIVE_TIME = 1L;//等待时间为 1L。

    public static void main(String[] args) {

        //通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                CODE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());

        //用来存放线程提交的返回值的列表
        List<Future<String>> futureList = new ArrayList<>();
        //Callable和Runable接口不同的是，Runable接口不会返回结果或抛出检查异常，但是Callable接口可以
        Callable<String> callable = new MyCallable();

        for (int i = 0; i < 10; i++) {
//            //创建WorkerThread对象（WorkerThread类实现了Runnable 接口）
//            Runnable worker = new MyRunnable("" + i);
//            //提交线程到线程池中 execute()方法用于提交不需要返回值的任务，所以无法判断任务是否被线程池执行成功与否；
//            threadPoolExecutor.execute(worker);

            //callable接口
            //submit提交和execute的区别时，submit用于提交需要返回值的任务，线程池会返回一个boolean类型的future对象，execute用于提交不需要返回值的任务
            Future<String> submit = threadPoolExecutor.submit(callable);
            //将返回值 future 添加到 list，我们可以通过 future 获得 执行 Callable 得到的返回值
            futureList.add(submit);
        }

        for (Future<String> stringFuture : futureList) {
            try {
                System.out.println(new Date() + "::" +stringFuture.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        //终止线程
        threadPoolExecutor.shutdown();

//        while (!threadPoolExecutor.isTerminated()){
//        }
//        System.out.println("Finished all threads");
    }

}
