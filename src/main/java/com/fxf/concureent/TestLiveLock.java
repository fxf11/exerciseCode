package com.fxf.concureent;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

/**
 * @Classname Test
 * @Description TODO 活锁
 * @Version 1.0.0
 * @Date 2022/1/15 14:29
 * @Created by 饭小范
 */
public class TestLiveLock {

    static volatile int count = 10;
    static final Object lock = new Object();

    public static void main(String[] args) {
//        new Thread(()->{
//           while (count > 0){
//               try {
//                   sleep(200);
//               } catch (InterruptedException e) {
//                   e.printStackTrace();
//               }
//               count--;
//               System.out.println("count:"+count);
//
//           }
//        },"t1").start();
//
//        new Thread(()->{
//            while (count < 20){
//                try {
//                    sleep(200);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                count++;
//                System.out.println("count:"+count);
//
//            }
//        },"t1").start();
        ReentrantLock lock = new ReentrantLock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println("第1次获取锁，这个锁是：" + lock);

                    int index = 1;
                    while (true) {
                        try {
                            lock.lock();
                            System.out.println("第" + (++index) + "次获取锁，这个锁是：" + lock);

                            try {
                                Thread.sleep(new Random().nextInt(200));
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            if (index == 10) {
                                break;
                            }
                        } finally {
                            lock.unlock();
                        }

                    }

                } finally {
                    lock.unlock();
                }
            }
        }).start();

    }
}
