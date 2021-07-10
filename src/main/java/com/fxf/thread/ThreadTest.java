package com.fxf.thread;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 多线程的创建，方式一：继承Thread类
 * @date 2021/7/8 22:53
 */
public class ThreadTest{

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.setName("线程x");
        myThread.start();
        int len = 100;
        Thread.currentThread().setName("主线程");
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0){
                Thread.sleep(200);
                System.out.println(Thread.currentThread().getName()+"："+i);
            }
            if (i == 26){
                try {
                    myThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        Object o = new Object();

        int len = 100;
        synchronized (o){
            for (int i = 0; i < len; i++) {
                if (i % 2 == 0){
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"："+i);
                }
                if (i % 20 == 0){
                    yield();
                }
            } 
        }

    }
}
