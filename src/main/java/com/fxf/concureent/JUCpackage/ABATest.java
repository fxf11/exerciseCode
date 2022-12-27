package com.fxf.concureent.JUCpackage;


import java.util.concurrent.atomic.AtomicReference;

import static java.lang.Thread.sleep;

/**
 * @Classname ABATest
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/1/23 22:29
 * @Created by 饭小范
 */
public class ABATest {

    static AtomicReference<String> ref = new AtomicReference<>("A");

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main start...");
        String prev = ref.get();
        other();
        sleep(1000);

        System.out.println(ref.get());
        System.out.println("change A->C "+ref.compareAndSet(prev,"C"));

    }

    private static void other() throws InterruptedException {
        new Thread(()->{
            System.out.println(ref.get());
            System.out.println("change A-B "+ref.compareAndSet(ref.get(),"B"));
        },"t1").start();
        sleep(500);
        new Thread(()->{
            System.out.println(ref.get());
            System.out.println("change B-A "+ref.compareAndSet(ref.get(),"A"));
        },"t2").start();
    }
}
