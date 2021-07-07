package com.fxf.lamda;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/6/20 22:45
 */
public class Lambda3 {

    private static class Person{
        private String name;

        public void setName(String name){
            this.name = name;
        }

        private String getName(){
            return name;
        }
    }

    @FunctionalInterface
    private interface MyInterface{
//        String get(Person person);
        void set(Person person,String name);
    }

    public static  void main(String[] args){
//        MyInterface lambda1 = x -> x.getName();
        //简化
        Person person = new Person();
        person.setName("xiaofan");

//        MyInterface lambda1 = Person::getName;
//        System.out.println(lambda1.get(person ));
        MyInterface lambda1 = (x,n) -> x.setName(n);
        MyInterface lambda2 = Person::setName;
        lambda2.set(person,"xiaozhu");
        System.out.println(person.getName());

    }
}
