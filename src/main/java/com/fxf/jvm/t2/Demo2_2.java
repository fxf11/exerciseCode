package com.fxf.jvm.t2;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 演示GC Roots
 * @date 2021/6/30 21:05
 */
public class Demo2_2 {

    public static void main(String[] args) throws IOException {

        ArrayList<Object> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        System.out.println(1);
        System.in.read();

        list = null;
        System.out.println(2);
        System.in.read();
        System.out.println("end...");

    }

}
