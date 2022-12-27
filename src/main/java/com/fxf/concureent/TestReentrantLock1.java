package com.fxf.concureent;

import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

/**
 * @Classname TestReentrantLock1
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/1/15 15:35
 * @Created by 饭小范
 */
public class TestReentrantLock1 {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            //尝试获得锁
            System.out.println("尝试获得锁");
            if (!lock.tryLock()){
                System.out.println("获取不到锁");
                return;
            }
            try {
                System.out.println("获得到锁");
            }finally {
                lock.unlock();
            }
        },"t1");

        lock.lock();
        t1.start();
    }
}
