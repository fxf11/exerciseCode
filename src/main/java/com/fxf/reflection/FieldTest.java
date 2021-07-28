package com.fxf.reflection;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 获取当前运行时类的属性结构
 * @date 2021/7/27 23:59
 */
public class FieldTest {

    @Test
    public void test1(){
        Class clazz = Person.class;
        //获取属性结构
        //获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field );
        }

        //获取当前运行时类中声明的所有属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
    }

    /**
     * 权限修饰符 数据类型 变量名
     */
    @Test
    public void test2(){
        Class personClass = Person.class;
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            //权限修饰符
            int modifiers = declaredField.getModifiers();
            System.out.println(Modifier.toString(modifiers));
            //数据类型
            Class<?> type = declaredField.getType();
            System.out.println(type.getName());
            //变量名
            String name = declaredField.getName();
            System.out.println(name);
        }


    }
}
