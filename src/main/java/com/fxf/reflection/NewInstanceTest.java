package com.fxf.reflection;

import org.junit.Test;

import java.util.Random;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 通过反射创建对应的运行时类的对象
 * @date 2021/7/27 22:05
 */
public class NewInstanceTest {

    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        Class<Person> personClass = Person.class;
        /*
            newInstance()：调用此方法，创建对应的运行时类的对象，内部调用了运行时类的空参的构造器

            要想此方法正常的创建运行时类的对象，要求：
                运行时类必须提供空参的构造器
                空参的构造器的访问权限得够。太长，设置为public

            通常在java bean中要求提供一个public的空参构造器
                便于通过反射，创建运行时类的对象
                便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器

         */
        Person person = personClass.newInstance();

        System.out.println(person);
    }

    @Test
    public void test2() throws IllegalAccessException, ClassNotFoundException {
        int num = new Random().nextInt(3);
        String classPath = "";
        switch (num){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.sql.Date";
                break;
            case 2:
                classPath = "com.fxf.reflection.Person";
                break;
        }
        try {
            Object instance = getInstance(classPath);
            System.out.println(instance);
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


    }

    /**
     * 创建一个指定类的对象
     * @param classPath
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public Object getInstance(String classPath) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class aClass = Class.forName(classPath);
        return aClass.newInstance();
    }
}
