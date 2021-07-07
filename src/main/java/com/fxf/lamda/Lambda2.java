package com.fxf.lamda;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/6/20 22:30
 */
public class Lambda2 {


    private static class Person{
        String name;
        int age;
        public Person(){
            System.out.println("Person类的无参构造方法执行了");
        }

        public Person(String name){
            this.name = name;
            System.out.println("Person类的有参构造方法执行力");
        }

        public Person(String name,int age){
            this.name = name;
            this.age = age;
            System.out.println("Person类的两个参数的构造方法执行力");
        }
    }

    @FunctionalInterface
    private interface GetPersonWithNoneParameter{
        Person get();
    }

    @FunctionalInterface
    private interface GetPersonWithSingleParameter{
        Person get(String name);
    }


    @FunctionalInterface
    private interface GetPersonWithMutipleParameter{
        Person get(String name,int age);
    }


    public static void main(String[] args) {

        //使用lambda表达式，实现GetPersonWithNoneParameter接口
        GetPersonWithNoneParameter getPerson = Person::new;
        //使用lambda表达式，实现GetPersonWithSingleParameter接口
        GetPersonWithSingleParameter getPerson2 = Person::new;
        //使用lambda表达式，实现GetPersonWithMutipleParameter接口
        GetPersonWithMutipleParameter getPerson3 = Person::new;

        Person person = getPerson.get();
        getPerson2.get("");
        getPerson3.get("",1);

    }
}
