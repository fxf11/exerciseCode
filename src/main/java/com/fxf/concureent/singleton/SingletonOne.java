package com.fxf.concureent.singleton;

import java.io.Serializable;

/**
 * @Classname SingletonOne
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/1/23 14:17
 * @Created by 饭小范
 *
 * 使用final修饰类防止被子类继承覆盖方法导致单例被破坏
 *
 * 线程安全 static静态成员变量属于类，在类加载阶段进行初始化，类加载阶段由JVM保证线程安全，所以是线程安全的
 *
 *
 */
public final class SingletonOne implements Serializable {

    public SingletonOne() {
    }

    private static final SingletonOne INSTANCE = new SingletonOne();

    public static SingletonOne getInstance(){
        return INSTANCE;
    }

    //当用反序列化创建对象的时候，会生成新的对象，反序列化生成的对象和单例维护的对象是不同的对象，会破坏单例，
    // 会调用readResolve(),为了防止类在反序列化的时候创建对象
    //防止反序列化破坏单例
    public Object readResovle(){
        return INSTANCE;
    }
}

//饿汉式，反编译查看源码的话，会发现INSTANCE，其实也是Singleton的一个静态成员变量，且enum类实现了Serializable，但是不会被反序列化破坏单例
enum Singleton{
    INSTANCE;
}

//懒汉式
final class SingletonTwo{
    private static SingletonTwo INSTANCE = null;
    private SingletonTwo() {
    }
    //synchronized保证多线程下的线程安全，但是会因为指令重排序导致有问题
    public static synchronized SingletonTwo getInstance(){
        if (INSTANCE != null){
            return INSTANCE;
        }
        INSTANCE = new SingletonTwo();
        return INSTANCE;
    }
}

//改进
final class SingletonTwoV2{
    //使用volatile防止指令重排序
    private static volatile SingletonTwoV2 INSTANCE = null;
    private SingletonTwoV2() {
    }
    //synchronized保证多线程下的线程安全，但是会因为指令重排序导致有问题
    public static SingletonTwoV2 getInstance(){
        if (INSTANCE != null){
            return INSTANCE;
        }
        synchronized(SingletonTwoV2.class){
            //重复判断防止多线程并发的问题
            if (INSTANCE != null){
                return INSTANCE;
            }
            INSTANCE = new SingletonTwoV2();
            return INSTANCE;
        }

    }
}
//懒汉式
final class SingletonTwoV3{
    private SingletonTwoV3() {
    }
    private static class LazyHolder{
        static final SingletonTwoV3 INSTANCE = new SingletonTwoV3();
    }
    //synchronized保证多线程下的线程安全，但是会因为指令重排序导致有问题
    public static SingletonTwoV3 getInstance(){
       return LazyHolder.INSTANCE;
    }
}
