package com.fxf.reflection;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

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
    public void test2() {
        Class<Person> personClass = Person.class;
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            //获得方法声明的注解
            Annotation[] annotations = declaredMethod.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }

            //权限修饰符
            System.out.println(Modifier.toString(declaredMethod.getModifiers()) + "\t");

            //返回值类型
            System.out.println(declaredMethod.getReturnType().getName() + "\t");

            //方法名
            System.out.println(declaredMethod.getName());
            System.out.println("--------------------------");
            //形参列表
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            if (parameterTypes == null && parameterTypes.length == 0) {
                for (Class<?> parameterType : parameterTypes) {
                    System.out.println(parameterType.getName() + "args_");
                }
            }

            //抛出的异常
            Class[] exceptionTypes = declaredMethod.getExceptionTypes();
            if (!(exceptionTypes == null && exceptionTypes.length == 0)){
                System.out.println("throws");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if (i == exceptionTypes.length -1){
                        System.out.println(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.println(exceptionTypes[i].getName() + ",");

                }
            }

        }
    }
}
