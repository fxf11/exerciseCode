package com.fxf.stream;

import com.fxf.reflection.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 测试Stream的中间操作
 * @date 2021/7/30 23:53
 */
public class StreamApiTest1 {

    /**
     * 筛选与切片
     */
    @Test
    public void test1(){

        List<Person> employees = StreamApiTest.getEmployees();
        //filter(Predicate p)--接收Lambda，从流中排除某些元素
        Stream<Person> stream = employees.stream();
        stream.filter(res -> res.getAge() > 15).forEach(System.out::println);
        System.out.println();
        //limit(n)—— 截断流，使其元素不超过给定数量
//        stream.limit(3).forEach(System.out::println);

        //skip(n)——跳过元素,返回一个扔掉了前n个元素的流，若流中元素不足n个，则返回
//        employees.stream().skip(3).forEach(System.out::println);

        employees.add(new Person("小饭",23));
        //distinct()——筛选，通过流所生成元素的hashCode() 和 equals() 去除重复元素
        System.out.println("-------------------------------------------");
        employees.stream().distinct().forEach(System.out::println);

    }

    /**
     * 映射
     */
    @Test
    public void test2(){
        //map(function f)——接受一个函数作为参数，将元素转换为其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        //获取姓名长度大于3的人
        List<Person> employees = StreamApiTest.getEmployees();
        Stream<Person> stream = employees.stream();
        //得到姓名的stream
        Stream<String> namesStream = stream.map(p -> p.getName());
        namesStream.filter(name -> name.length() > 3).forEach(System.out::println);
        System.out.println("---------------------");
        //练习2
        Stream<Stream<Character>> streamStream = list.stream().map(StreamApiTest1::fromStringToStream);
        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });
        System.out.println("-----------------");
        //flatMap(Function f)——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
        Stream<Character> characterStream = list.stream().flatMap(StreamApiTest1::fromStringToStream);
        characterStream.forEach(System.out::println);
    }

    @Test
    public void test4(){
        //sorted()——自然排序
        List<Integer> list = Arrays.asList(12, 65, 87, 45, 95, 62, 42, 55);
        list.stream().sorted().forEach(System.out::println);

        //异常：Person cannot be cast to java.lang.Comparable ，Person类没有实现Comparable接口
//        List<Person> employees = StreamApiTest.getEmployees();
//        employees.stream().sorted().forEach(System.out::println);


        //sorted(Comparator com)——定制排序
        List<Person> employees = StreamApiTest.getEmployees();
//        employees.stream().sorted((e1,e2) -> Integer.compare(e1.getAge(),e2.getAge())).forEach(System.out::println);

        //定制排序
        employees.stream().sorted((e1,e2) -> {

            int ageValue = Integer.compare(e1.getAge(), e2.getAge());
            if (ageValue != 0){
                return ageValue;
            }else{
                return Double.compare(e1.getAge(),e2.getAge());
            }

        }).forEach(System.out::println);
    }

    /**
     * 将字符串中的多个字符构成的集合转换为对应的Stream的实例
     */
    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for (Character c: str.toCharArray()) {
            list.add(c);
        }
        Stream<Character> stream = list.stream();
        return stream;
    }

    @Test
    public void test3(){
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        ArrayList list1 = new ArrayList();
        list1.add(4);
        list1.add(5);
        list1.add(6);

        list.addAll(list1);
        System.out.println(list);

    }
}
