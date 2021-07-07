package com.fxf.jvm.t1;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/6/24 21:52
 */
public class Demo1_1 {

    public static void main(String[] args) {

        method1();
    }

    private static void method1(){
        method2(1,2);
    }

    private static int method2(int a,int b){
        int c = a+b;
        return c;
    }
}
