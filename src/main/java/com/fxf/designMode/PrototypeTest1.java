package com.fxf.designMode;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 原型模式实例
 * @date 2021/6/29 22:55
 */
public class PrototypeTest1 {

    public static void main(String[] args) throws CloneNotSupportedException {

        citation obj1 = new citation("张三","同学：在2016学年第一学期中表现优秀，被评为三好学生。", "韶关学院");
        obj1.display();
        citation obj2 = (citation) obj1.clone();
        obj2.setName("李四");
        obj2.display();
    }
}

class citation implements Cloneable{

    String name;
    String info;
    String college;

    citation(String name, String info, String college) {
        this.name = name;
        this.info = info;
        this.college = college;
        System.out.println("奖状创建成功！");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    void display(){
        System.out.println(name + info + college);
    }

    public Object clone() throws CloneNotSupportedException {
        System.out.println("奖状拷贝成功！");
        return (citation) super.clone();
    }

}
