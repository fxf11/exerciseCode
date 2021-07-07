package com.fxf.jvm.t1;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/6/29 21:52
 */
public class Demo1_26 {
    static int _1GB = 1024 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_1GB);
        System.out.println("分配完毕");
        System.in.read();
        System.out.println("开始释放");
        byteBuffer = null;
        System.gc();//显式的垃圾回收
        System.in.read();

    }
}
