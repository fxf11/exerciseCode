package com.fxf.interview;

import com.fxf.reflection.Person;
import org.junit.Test;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO Java深拷贝和浅拷贝
 * @date 2021/8/2 22:44
 */
public class DeepOrShallowCopy {


    public static void main(String[] args) {

        //引用拷贝
        Person person = new Person("fxf", 21);
        Person person1 = person;

        System.out.println(person);//com.fxf.reflection.Person@14ae5a5
        System.out.println(person1);//com.fxf.reflection.Person@14ae5a5

        //对象拷贝
        Person fxf = new Person("fxf1", 22);
    }


    /**
     * 浅拷贝实例
     * @throws CloneNotSupportedException
     */
    @Test
    public void shallowCopy() throws CloneNotSupportedException {

        Person person = new Person();
        person.setAge(20);
        person.setName("fxf");


        Student2 student2 = new Student2();
        student2.setAge(21);
        student2.setName("zjw");
        student2.setPerson(person);

        Student2 clone = (Student2) student2.clone();
        System.out.println("-------------拷贝后---------------");
        System.out.println(clone.getName());
        System.out.println(clone.getAge());
        System.out.println(clone.getPerson().getAge());
        System.out.println(clone.getPerson().getName());
        System.out.println("对老师信息进行修改");

        person.setName("fanzhijie");
        System.out.println(student2.getPerson().getName());
        System.out.println(clone.getPerson().getName());



    }
}

class Student2 implements Cloneable{
    private String name;
    private int age;
    private Person person;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        //浅拷贝
//        Object object = super.clone();
//        return object;

        //深拷贝
        Student2 student = (Student2) super.clone();
        // 本来是浅复制，现在将Teacher对象复制一份并重新set进来
        student.setPerson((Person) student.getPerson().clone());
        return student;

    }

}
