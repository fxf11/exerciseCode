package com.fxf.jvm.t1;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 演示栈内存溢出  java.lang.StackOverflowError
 * @date 2021/6/24 22:31
 */
public class Demo1_2 {

    private static int count;
    

    public static void main(String[] args){
        try {
            method1();
        }catch (Throwable t){
            t.printStackTrace();
            System.out.println(count);
        }
    }
    private static void method1(){
        count++;
        method1();
    }
}
