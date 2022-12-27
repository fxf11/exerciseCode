package com.fxf.thread;

import static java.lang.Thread.sleep;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 测试Thread中的常用方法
 * @date 2021/7/8 23:35
 */
public class ThreadMethod {

    static int r = 0;
    public static void main(String[] args) throws InterruptedException {
        test1();
    }
    private static void test1() throws InterruptedException {
        System.out.println("开始");
        Thread t1 = new Thread(() -> {
            System.out.println("开始");
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("结束");
            r = 10;
        });
        t1.start();
        t1.join();
        System.out.println("结果为:{}"+r);
        System.out.println("结束");

    }
}
