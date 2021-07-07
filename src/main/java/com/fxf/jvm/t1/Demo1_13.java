package com.fxf.jvm.t1;

import java.util.ArrayList;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 演示查看对象个数 堆转储 dump
 * @date 2021/6/25 23:09
 */
public class Demo1_13 {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            students.add(new Student());
        }
        Thread.sleep(1000000000L);
    }
}

class Student {
    private byte[] big = new byte[1024*1024];
}
