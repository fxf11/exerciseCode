package com.fxf.lamda.syntax;

import com.fxf.lamda.functuionalInterfaces.NoneRetrunNoneParameter;
import com.fxf.lamda.functuionalInterfaces.NoneReturnMutipleParameter;
import com.fxf.lamda.functuionalInterfaces.SingleReturnSingleParameter;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 语法进阶
 * @date 2021/6/20 21:40
 */
public class BasicPro {

    public static void main(String[] args) {
        //实现一个参数，有返回值的函数式接口
        SingleReturnSingleParameter lambda1 = a -> a * a;

        System.out.println(lambda1.test(10));

        NoneReturnMutipleParameter lambda2 = (a,b) -> System.out.println(a+b);

        NoneRetrunNoneParameter lambda3 = () -> {};
    }
}
