package com.fxf.jvm.t1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 演示堆内存溢出
 * @date 2021/6/25 22:37
 */
public class Demo1_4 {

    public static void main(String[] args) {
        int i = 0;

        try {
            List<String> list = new ArrayList<>();
            String s = "hello";
            while (true){
                list.add(s);
                s = s + s;
                i++;
            }
        }catch (Throwable e){
            e.printStackTrace();
            System.out.println(i);
        }
    }
}
