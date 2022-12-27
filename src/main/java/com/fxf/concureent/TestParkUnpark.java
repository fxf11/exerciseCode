package com.fxf.concureent;

import java.util.concurrent.locks.LockSupport;

import static java.lang.Thread.sleep;

/**
 * @Classname TestParkUnpark
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/1/13 23:39
 * @Created by 饭小范
 */

public class TestParkUnpark {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            System.out.println("start...");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("park...");
            LockSupport.park();
            LockSupport.park();
            System.out.println("resume...");
        },"t1");
        thread.start();
        sleep(4000);
        System.out.println("unpark");
        LockSupport.unpark(thread);

    }
}
