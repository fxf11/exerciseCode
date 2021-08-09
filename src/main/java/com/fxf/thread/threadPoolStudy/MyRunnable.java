package com.fxf.thread.threadPoolStudy;

import java.util.Date;

/**
 * @Description TODO 这是一个简单的Runnable类，需要大约5秒钟来执行其任务。
 * @Author Administrator
 * @Date 2021/8/9 9:51
 * @Version 1.0
 */
public class MyRunnable implements Runnable{

    private String command;

    public MyRunnable(String s){
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
    }

    public void processCommand(){
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();

        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
