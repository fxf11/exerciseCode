package com.fxf.stream;

import com.fxf.reflection.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 测试Stream的种植操作
 * @date 2021/7/31 1:27
 */
public class StreamTest3 {

    /**
     * 匹配与查找
     */

    @Test
    public void test1(){
        List<Person> employees = StreamApiTest.getEmployees();
        //allMatch检查是否匹配所有元素
        boolean b = employees.stream().allMatch(e -> e.getAge() > 10);
        System.out.println(b);
        //anyMatch:检查是否至少匹配一个元素
        boolean b1 = employees.stream().anyMatch(e -> e.getAge() > 20);
        System.out.println(b1);

        //noneMatch(Predicate p)：检查是否没有匹配的元素。
        boolean res = employees.stream().noneMatch(e -> e.getName().startsWith("范"));
        System.out.println(res);

        //findFirst:返回第一个元素
        Optional<Person> first = employees.stream().findFirst();
        System.out.println(first);

        //findAny——返回当前流中的任意元素
        Optional<Person> any = employees.parallelStream().findAny();
        System.out.println(any);

    }

    @Test
    public void test2(){
        //count——返回流中元素的总个数
        List<Person> employees = StreamApiTest.getEmployees();
        long count = employees.stream().filter(e -> e.getAge() > 15).count();
        System.out.println(count);

        //max(Comparator c)——返回流中的最大值
        Optional<Integer> max = employees.stream().map(e -> e.getAge()).max(Double::compare);
        System.out.println(max);
        //min(Comparator c)——返回流中的最小值
        Optional<Integer> min = employees.stream().map(e -> e.getAge()).min(Double::compare);
        System.out.println(min);
        //forEach(Consumer c)——内部迭代
        employees.stream().forEach(System.out::println);
    }

    /**
     * 归约
     */
    @Test
    public void test3(){
        //reduce(T identity, BinaryOperator)——可以将流中元素反复结合起来，得到一个值，

        //计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

        //reduce(BinaryOperator)——可以将流中元素反复结合起来，得到一个值，返回Optional<T>
        //计算公司所有人岁数的总和
        List<Person> employees = StreamApiTest.getEmployees();
        Stream<Integer> stream = employees.stream().map(Person::getAge);
        Optional<Integer> reduce1 = stream.reduce(Integer::sum);
        System.out.println(reduce1);

    }

    /**
     * 收集
     */
    @Test
    public void test4(){
        //collect(Collector c)——将流转换为其他形式，接收一个Collector接口的实现，用于给Stream中的元素做汇总的方法

        //查找年纪大于20的人，结果返回一个list或者set
        List<Person> employees = StreamApiTest.getEmployees();
        List<Person> collect = employees.stream().filter(e -> e.getAge() > 20).collect(Collectors.toList());
        System.out.println(collect.toString());
        collect.forEach(System.out::println);


        Set<Person> collect1 = employees.stream().filter(e -> e.getAge() > 20).collect(Collectors.toSet());
        System.out.println(collect1.toString());
        collect1.forEach(System.out::println);


    }

}
