package com.fxf.concureent;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.locks.LockSupport;

/**
 * @Classname TestBiased
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/1/9 16:51
 * @Created by 饭小范
 */

public class TestBiased {

    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(ClassLayout.parseInstance(dog).toPrintable());

//        LockSupport.
    }
}

class Dog{

}
