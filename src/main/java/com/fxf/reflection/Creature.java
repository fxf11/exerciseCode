package com.fxf.reflection;

import java.io.Serializable;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/7/27 23:45
 */
public class Creature<T> implements Serializable {

    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }
}
