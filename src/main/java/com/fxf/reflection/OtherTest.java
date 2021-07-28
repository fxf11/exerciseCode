package com.fxf.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/7/28 22:48
 */
public class OtherTest {

    @Test
    public void test1(){
        Class<Person> personClass = Person.class;
        //获取当前运行时类中声明为public的构造器
        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        //获取当前运行时类中所有的构造器
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
    }

    @Test
    public void test2(){
        Class personClass = Person.class;
        Class superclass = personClass.getSuperclass();
        System.out.println(superclass);
    }

    /**
     * 获取运行时类的带泛型的父类
     */
    @Test
    public void test3(){
        Class personClass = Person.class;
        Type genericSuperclass = personClass.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }

    /**
     * 获取运行时类实现的接口
     */

    @Test
    public void test4(){
        Class personClass = Person.class;
        Class[] interfaces = personClass.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }

        //获取运行所在的包

        Package aPackage = personClass.getPackage();
        System.out.println(aPackage);
    }

    @Test
    public void testMethod() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class personClass = Person.class;

        Person o = (Person) personClass.newInstance();

        /**
         * 获取指定的方法
         */
        Method show = personClass.getDeclaredMethod("showNation", String.class);
        //保证当前方法可以
        show.setAccessible(true);

        /**
         * 调用方法的invoke：参数1是方法的调用者，参数二是给方法形参复制的实参
         *
         * invoke方法的返回值即为对应的类中调用的方法的返回值
         */
        Object chn = show.invoke(o, "CHN");
        System.out.println(chn);

        //调用静态方法
        Method showDesc = personClass.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);

        Object invoke = showDesc.invoke(Person.class);
        System.out.println(invoke);
    }

    @Test
    public void testConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Person> personClass = Person.class;

        Constructor<Person> constructor = personClass.getDeclaredConstructor(String.class);

        //保证此构造器是可访问的
        constructor.setAccessible(true);

        Person person = constructor.newInstance("Tom");
        System.out.println(person);

;
    }

}
