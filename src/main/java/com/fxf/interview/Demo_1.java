package com.fxf.interview;

import com.fxf.reflection.Person;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/8/2 20:49
 */
public class Demo_1 {

    public static int test(Integer a){
        //返回值会被finally中覆盖
        try {
            return a * a ;
        }finally {
            if (a == 2){
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        Class<Person> personClass = Person.class;
        Method[] declaredMethods = personClass.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            String name = declaredMethod.getName();
            System.out.print("方法名："+name);

            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                String name1 = parameterType.getName();
                System.out.print("参数类型："+name1);
            }

            System.out.println();
        }


//        Method setAge = personClass.getDeclaredMethod('showNation');

        try {
            Method setName = personClass.getDeclaredMethod("setName", String.class);
            System.out.println(setName.getName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test1(){
        String a = new String("ab");
        String b = new String("ab");

        String aa = "ab";
        String bb = "ab";

        System.out.println(a==b);//false
        System.out.println(a==aa);//false
        System.out.println(aa==bb);//true
        System.out.println(aa.equals(bb));//true

    }

    @Test
    public void test2(){
        int test = test(2);
        System.out.println(test);
    }
}
