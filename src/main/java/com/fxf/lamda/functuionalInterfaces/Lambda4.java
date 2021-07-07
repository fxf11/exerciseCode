package com.fxf.lamda.functuionalInterfaces;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/6/20 23:07
 */
public class Lambda4 {

    public static void main(String[] args) {
        // 定义一个局部变量
        int x = 10;

        // 使用lambda表达式的实现接口
        LambdaTest lambda = () -> {
            System.out.println("x = " + x);
        };
        // 修改变量的值
        // x = 20;
        //
    }

}

@FunctionalInterface
interface LambdaTest{
    void test();
}
