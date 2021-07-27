package com.fxf;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO  了解类的加载器
 * @date 2021/7/27 21:40
 */
public class ClassLoaderTest {


    @Test
    public void test1(){
        //对于自定义类，使用系统类加载器精进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        //调用系统类加载的getParent(); 获取扩展类加载器
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);

        //调用扩展类加载器的getParent()：无法获取引导类加载器
        //引导类加载器主要负责加载Java的核心类库没无法加载自定义类
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);
    }


    /**
     * Properties：用来读取配置文件
     */
    @Test
    public void test2() throws IOException {

        Properties properties = new Properties();
//        FileInputStream fileInputStream = new FileInputStream("jdbc.properties");
//        properties.load(fileInputStream);

        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
        properties.load(is);

        String name = properties.getProperty("name");
        String password = properties.getProperty("password");

        System.out.println(name+"-------"+password);


    }
}
