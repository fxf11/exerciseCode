package com.fxf.concureent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname TestReentrantLock
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/1/15 15:14
 * @Created by 饭小范
 */
public class TestReentrantLock {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock.lock();

        try {
            System.out.println("enter main");
            m2();
        }finally {
            lock.unlock();
        }
    }

    public static void m1(){
        lock.lock();
        try {
            System.out.println("enter m1");
            m2();
        }finally {
            lock.unlock();
        }
    }

    public static void m2(){
        lock.lock();
        try {
            System.out.println("enter m2");
        }finally {
            lock.unlock();
        }
    }
}
