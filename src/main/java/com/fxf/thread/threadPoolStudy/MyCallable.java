package com.fxf.thread.threadPoolStudy;

import java.util.concurrent.Callable;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2021/8/9 10:49
 * @Version 1.0
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        //返回当前callable线程的名字
        return Thread.currentThread().getName();
    }
}
