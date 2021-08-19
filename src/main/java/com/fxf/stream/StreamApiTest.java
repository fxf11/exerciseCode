package com.fxf.stream;

import com.fxf.reflection.Person;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1. Stream关注的是对数据的运算，与CPU打交道
 *      集合关注的是数据的存储，与内存打交道
 *
 *
 * 2.
 *  ①Stream 自己不会存储元素
 *  ②Stream 不会改变源对象，相反他们会返回一个持有结果的新Stream
 *  ③Stream 操作时延迟执行的，这意味着他们会等到需要结果的时候才执行
 *
 * 3.Stream执行流程
 * ① Stream实例化
 * ② 一系列的中间操作（过滤、映射...）
 * ③ 终止操作
 *
 * 说明：
 *      一个中间操作链，对数据源的数据进行处理
 *      一旦执行终止操作，就执行中间操作连，并产生结果，之后，不会再被使用
 *
 *
 *
 * @author 饭小范
 * @version 1.0
 * @description: TODO Stream
 * @date 2021/7/30 23:15
 */
public class StreamApiTest {

    public static void main(String[] args) {

        for (String arg : args) {
            System.out.println(arg);
        }

    }

    //通过集合创建Stream
    @Test
    public void test(){
        List<Person> employees = getEmployees();

        //default Stream<E> steam()：返回一个顺序流
        Stream<Person> stream = employees.stream();

        //default Stream<E> parallelStream()：返回一个顺序流
        Stream<Person> personStream = employees.parallelStream();
    }

    @Test
    public void test2(){
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        IntStream stream = Arrays.stream(arr);

        Person person = new Person("fxf", 12);
        Person person1 = new Person("fzj", 23);
        Person[] arr1 = new Person[]{person,person1};
        Stream<Person> stream1 = Arrays.stream(arr1);
    }
    /**

     * 通过Stream的of()创建Stream
     */
    @Test
    public void test3(){

        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7);

    }

    /**
     * 创建Steam无限流
     * @return
     */
    @Test
    public void test4(){

        //迭代
        //遍历前十个偶数
//        Stream.iterate(0,t -> t+2).limit(20).forEach(System.out::println);

        //生成
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }


    public static List<Person> getEmployees(){

        ArrayList<Person> list = new ArrayList<>();

        list.add(new Person("范志杰",19));
        list.add(new Person("范志杰1",12));
        list.add(new Person("范小饭",13));
        list.add(new Person("朱小猪",12));
        list.add(new Person("小猪猪",17));
        list.add(new Person("小朱",14));
        list.add(new Person("小饭",23));
        list.add(new Person("小饭",23));

        return list;

    }

    @Test
    public void test5(){
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(4);
        ids.add(3);
        List<Long> longs = ids.stream().map(s -> Long.parseLong(String.valueOf(s))).collect(Collectors.toList());
        System.out.println(longs);
    }

}
