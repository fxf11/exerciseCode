package com.fxf.jvm.t1;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 演示字符串字面量也是【延迟】成为对象的
 * @date 2021/6/28 21:19
 */
public class TestString {

    public static void main(String[] args) {
        int x = args.length;
        System.out.println(x);  //字符串个数 2232
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("0");
        System.out.println("1");//字符串个数 2242
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");//字符串个数 2242
        System.out.println(x);
    }
}
