package com.fxf.thread;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/7/8 23:15
 */
public class ThreadTest1{
    public static void main(String[] args) {
        MyThread1 myThread = new MyThread1();
        Thread thread = new Thread(myThread);
        thread.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("test");
            }
        }).start();

        new Thread(() -> {
            System.out.println("test");
        }).start();

        int len = 100;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}

class MyThread1 implements Runnable{
    @Override
    public void run() {
        int len = 100;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}
