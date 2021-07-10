package com.fxf.designMode;

import java.awt.*;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 用带原型管理器的原型模式来生成包含“圆”和“正方形”等图形的原型，并计算其面积。
 * @date 2021/6/29 23:04
 *
 * 分析：本实例中由于存在不同的图形类，例如，“圆”和“正方形”，它们计算面积的方法不一样，所以需要用一个原型管理器来管理它们
 */
interface Shape extends Cloneable {
    /**
     * 拷贝
     * @return
     */
    public Object clone();

    /**
     * 计算面积
     */
    public void countArea();
}

class Circle implements Shape{//具体原型

    @Override
    public Object clone() {
        Circle w = null;
        try {
            w = (Circle) super.clone();
        }catch (CloneNotSupportedException e) {
            System.out.println("拷贝圆失败!");
        }
        return w;
    }

    @Override
    public void countArea() {
        int r = 0;
        System.out.println("这是一个圆，请输入圆的半径：");
        Scanner input = new Scanner(System.in);
        r = input.nextInt();
        System.out.println("该圆的面积=" + 3.1415 * r * r + "\n");
    }
}

class Square implements Shape{//具体原型

    @Override
    public Object clone() {
        Square w = null;
        try {
            w = (Square) super.clone();
        }catch (CloneNotSupportedException e) {
            System.out.println("拷贝正方形失败!");
        }
        return w;
    }

    @Override
    public void countArea() {
        int a = 0;
        System.out.print("这是一个正方形，请输入它的边长：");
        Scanner input = new Scanner(System.in);
        a = input.nextInt();
        System.out.println("该正方形的面积=" + a * a + "\n");
    }
}

class ProtoTypeManager {//原型管理器
    private HashMap<String, Shape> ht = new HashMap<String, Shape>();

    public ProtoTypeManager(){
        ht.put("Circle", new Circle());
        ht.put("Square", new Square());
    }

    public void addShape(String key,Shape obj){
        ht.put("Circle",new Circle());
    }

    public Shape getShape(String key) {
        Shape temp = ht.get(key);
        return (Shape) temp.clone();
    }
}

/**
 * 访问类
 */
class ProtoTypeShape {
    public static void main(String[] args) {
        ProtoTypeManager pm = new ProtoTypeManager();
        Shape obj1 = (Circle) pm.getShape("Circle");
        obj1.countArea();
        Shape obj2 = (Shape) pm.getShape("Square");
        obj2.countArea();
    }
}

