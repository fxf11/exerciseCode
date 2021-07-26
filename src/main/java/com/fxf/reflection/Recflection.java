package com.fxf.reflection;

import org.junit.Test;
import sun.reflect.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/7/27 0:21
 */
public class Recflection {

    @Test
    public void test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class aClass = Person.class;

        //通过反射，创建Person类的对象
        Constructor constructors = aClass.getConstructor(String.class,int.class);
        Object tom = constructors.newInstance("Tom", 12);
        Person tom1 = (Person) tom;
        System.out.println(tom1.toString());

        //通过反射，调用对象指定的属性和方法
        //调用属性
        Field age = aClass.getDeclaredField("age");
        age.set(tom1,10);
        System.out.println(tom1.toString());

        //调用方法
        Method show = aClass.getDeclaredMethod("show");
        show.invoke(tom1);

        //通过反射，可以调用Person类的私有结构的，比如：私有的构造器、方法、属性

        //调用私有构造器
        Constructor con = aClass.getDeclaredConstructor(String.class);
        con.setAccessible(true);
        Person jerry = (Person) con.newInstance("jerry");
        System.out.println(jerry);

        //调用私有属性
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(tom1,"HanMeimei");
        System.out.println(tom1);

        //调用私有的方法
        Method showNation = aClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(tom1, "中国");
        System.out.println(nation);
    }

    /**
     * 类的加载过程：
     *  程序经过javac.exe命令以后，会生成一个或多个字节码文件（.class结尾）
     *  接着我们使用Java.exe命令会对某个字节码文件惊醒解释运行。相当于将某个字节码文件加载到内存中
     *  此过程就成为类的加载，加载到内存中的类，我们就称为运行时类，此运行时类，就作为Class的一个实例
     *
     *  Class的实例就对应着一个运行时类
     *
     * 加载到内存中的运行时类，会缓存一定的时间，在此时间之内，我们可以通过不同的方式来获取此运行时类
     *
     * 通过反射获取Class的实例的四种方式
     */

    @Test
    public void test3() throws ClassNotFoundException {
        //调用运行时类的属性
        Class aClass = Person.class;
        System.out.println(aClass);

        //通过运行时类的对象，调用getClass()
        Person person = new Person();
        Class aClass1 = person.getClass();
        System.out.println(aClass1);

        //方式三：调用Class的静态方法：forName(String classPath)
        Class person1 = Class.forName("com.fxf.reflection.Person");
        System.out.println(person1);

        //方式四：使用类加载器ClassLoader
        ClassLoader classLoader = Recflection.class.getClassLoader();
        Class aClass2 = classLoader.loadClass("com.fxf.reflection.Person");
        System.out.println(aClass);

    }
}
