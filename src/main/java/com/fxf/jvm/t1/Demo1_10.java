package com.fxf.jvm.t1;

import java.nio.ByteBuffer;
import java.util.ArrayList;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 演示直接内存溢出 java.lang.OutOfMemoryError: Direct buffer memory
 * @date 2021/6/29 21:49
 */
public class Demo1_10 {

    static int _100MB = 1024 * 1024 * 100;

    public static void main(String[] args) {

        ArrayList<ByteBuffer> list = new ArrayList<>();

        int i = 0;
        try {
            while (true){
                ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_100MB);
                list.add(byteBuffer);
                i++;
            }
        }finally {
            System.out.println(i);
        }
    }
}
