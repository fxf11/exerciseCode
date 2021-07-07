package com.fxf.lamda.syntax;

import com.fxf.lamda.functuionalInterfaces.*;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO lambda表达式的基础语法
 * @date 2021/6/20 21:15
 */
public class BasicSyntax {

    public static void main(String[] args) {

        //实现无参、无返回值的函数式接口
        NoneRetrunNoneParameter lambda1 = () -> {
            System.out.println("这是一个无参、无返回值的方法");
        };
        lambda1.test();

        //实现一个参数、无返回值的函数式接口
        NoneReturnSingleParameter lambda2 = (int a) -> {
            System.out.println("这是一个参数、无返回值的方法，参数a：" +a);
        };
        lambda2.test(12);

        //实现多个参数、无返回值的函数式接口
        NoneReturnMutipleParameter lambda3 = (int a, int b) -> {
            System.out.println("这是多个参数，无返回值的方法，参数a:" + a + ", b = " + b);
        };
        lambda3.test(100,200);

        //实现无参，有返回值的函数式接口
        SingleReturnNoneParameter lambda4 = () -> {
            System.out.println("这是无参，有返回值的方法："+10);
            return 10;
        };
        int ret1 = lambda4.test();
        System.out.println(ret1);

        //实现一个参数，有返回值的函数式接口
        SingleReturnSingleParameter lambda5 = (int a) -> {
            System.out.println("这是一个参数，有返回值的方法，返回值是:"+a);
            return a;
        };
        int ret2  = lambda5.test(328);
        System.out.println(ret2);

        //实现两个参数，有返回值的函数式接口
        SingleReturnMutipleParameter lambda6 = (int a, int b) -> {
            System.out.println("这是多个参数，有返回值的方法：");
            return a+b;
        };
        int ret3 = lambda6.test(200, 100);
        System.out.println(ret3);
    }
}
