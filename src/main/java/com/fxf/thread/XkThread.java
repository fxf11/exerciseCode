package com.fxf.thread;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/8/18 0:36
 */
public class XkThread extends Thread {

    private int i = 5;


    @Override
    public void run() {

        System.out.println("i="+(i--)+"threadName"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        XkThread xkThread = new XkThread();
        Thread thread = new Thread(xkThread);
        Thread thread1 = new Thread(xkThread);
        Thread thread2 = new Thread(xkThread);
        Thread thread3 = new Thread(xkThread);
        Thread thread4 = new Thread(xkThread);

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
