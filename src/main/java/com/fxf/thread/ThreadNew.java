package com.fxf.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 创建线程的方式三：实现callable接口创建线程
 * @date 2021/7/11 16:14
 */
public class ThreadNew {

    public static void main(String[] args) {
        //创建Callable接口实现类的对象
        NumThread numThread = new NumThread();
        //将此Callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask(numThread);
        //将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并start()启动线程
        Thread thread = new Thread(futureTask);
        thread.start();

        try {
            //get方法返回值即为FutureTask构造参数Callable实现类重写的call()的返回值
            Object o = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 创建一个Callable的实现类
 */
class NumThread implements Callable{

    /**
     *  实现call方法，将此线程需要执行得操作声明在call()中
     */
    @Override
    public Object call() throws Exception {
        int len = 100;
        int sum = 0;
        for (int i = 0; i <= len; i++) {
            if (i % 2 == 0){
                System.out.println(i);
                sum += i;
            }

        }
        return sum;
    }
}
