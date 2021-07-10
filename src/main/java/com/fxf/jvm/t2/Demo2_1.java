package com.fxf.jvm.t2;

import java.util.ArrayList;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/7/6 22:31
 */
public class Demo2_1 {
    private static final int _512KB = 512 * 1024;
    private static final int _1MB = 1024 * 1024;
    private static final int _6MB = 6 * 1024 * 1024;
    private static final int _7MB = 7 * 1024 * 1024;
    private static final int _8MB = 8 * 1024 * 1024;

    /**
     * Xms20M -Xmx20M：初始和最大堆空间为20MB
     * -XX:+UseSerialGC：一种垃圾回收器
     * XX:+PrintGCDetails -verbose:gc：打印GC详情
     * -Xmn10M：新生代10M
     * -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        //一个线程内的内存溢出不会导致主线程的进程结束
        new Thread(() -> {
            ArrayList<byte[]> list = new ArrayList<>();
            list.add(new byte[_8MB]);
            list.add(new byte[_8MB]);
        }).start();
        System.out.println("sleep....");
        Thread.sleep(1000L);

    }
}
