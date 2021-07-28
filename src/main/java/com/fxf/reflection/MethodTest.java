package com.fxf.reflection;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/7/28 0:17
 */
public class MethodTest {

    @Test
    public void test1(){
        Class<Person> personClass = Person.class;
        //获取当前运行时类及其所有父类中声明为oublic权限的方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        //获取当前类中声明的所有方法
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

    }

    /**
     * 权限修饰符  返回值类型   方法名（参数类型1  形参名1...）
     */
    @Test
    public void test2(){


    }
}
