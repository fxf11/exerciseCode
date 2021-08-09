package com.fxf.test;

import java.util.HashMap;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 演示HashMap的线程不安全性
 * @date 2021/8/2 23:57
 */
public class HashMapInfiniteLoop {

    private static HashMap<Integer,String> map = new HashMap<Integer,String>(2,0.75f);

    public static void main(String[] args) {
        map.put(5,"C");

        new Thread("Thread1") {
            public void run() {
                map.put(7, "B");
                System.out.println(map);
            };
        }.start();
        new Thread("Thread2") {
            public void run() {
                map.put(3, "A");
                        System.out.println(map);
            };
        }.start();
    }
}
