package com.fxf.jvm.t2;

import java.util.ArrayList;

/**
 *
 * -Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError
 * 限制堆内存大小为20M，不可扩展，通过-XX:+HeapDumpOnOutOfMemoryError可以让虚拟机出现内存溢出时dump出当前内存堆转储快照
 *
 * @Description TODO 堆内存溢出演示
 * @Author Administrator
 * @Date 2021/7/20 9:36
 * @Version 1.0
 */
public class HeapOOM {

    static class OOMObject{

    }

    public static void main(String[] args) {
        ArrayList<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
