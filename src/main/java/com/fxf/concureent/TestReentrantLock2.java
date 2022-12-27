package com.fxf.concureent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname TestReentrantLock2
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/1/15 16:31
 * @Created by 饭小范
 */
public class TestReentrantLock2 {

    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        //创建一个新的条件变量（阻塞队列）
        Condition condition2 = lock.newCondition();
        Condition condition1 = lock.newCondition();

        lock.lock();
        try {
            condition1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        condition1.signal();
        condition1.signalAll();

    }
}
