package com.fxf.lamda.interfaces;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/6/20 17:53
 */
public class Test1 {

}
@FunctionalInterface
interface Test2{
    void test2();
}

@FunctionalInterface
interface test3{
    void test3();
    default void test(){}
    static void test1(){}
    String toString();
}
