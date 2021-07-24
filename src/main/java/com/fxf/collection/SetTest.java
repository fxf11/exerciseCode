package com.fxf.collection;

import org.junit.Test;

import java.util.*;

/**
 *
 * Set接口时Collection的子接口，Set接口没有提供额外的方法
 * Set判断两个对象是否相同需要用equals()方法
 * Set不允许重复相同的元素
 *
 * Set：无序不可重复
 *
 * 实现：
 *      HashSet：作为Set接口的主要实现类：线程不安全的，可以存储null值
 *          LinkedHashSet：HashSet的一个子类在HashSet的基础上加了指针和链表，
 *              使得遍历内部数据时，可以按照添加的顺序遍历出来，看似有序，实则无序
 *      TreeSet：底层使用二叉树存储，可以按照添加对象的指定属性来进行排序
 *
 *
 * 疑问？
 *      如何理解无序不可重复？
 *          无序性不等于随机性，存储的数据在底层数组中宾菲按照数组所有的顺序添加，而是根据数据的哈希值
 *          不可重复性：保证添加的元素按照equals方法判断，不能返回true，相同元素只能添加一个
 *              Set集合添加时，会调用equals方法来判断参数是否存在，如果equals返回为true，则不能添加
 *
 *          以HashSet为例，添加元素的过程中，首先调用添加元素所在类的hashCode()方法，计算元素a的哈希值，
 *          此哈希值接着通过某种算法计算出在HashSet底层数组中存放的位置（即索引位置），判断数组此位置上是否有元素，如果没有其他元素则添加成功，
 *          如果此位置上有其他元素（或者以链表形式存在的多个元素），则比较此元素和其他元素的hash值，如果hash值不相同则直接添加成功（在索引位置上以链表的方式存储），
 *          如果hahsh值相同则再次调用equals方法，根据equals比对后返回值
 *
 *
 *          HashSet底层时数组加链表的结构
 *
 * Set接口没有额外定义新的方法，使用的都是Collection中声明过的方法
 *
 * 要求：向Set中添加的数据，其所在的类一定要重写hashCode()和equals()
 *
 * @author 饭小范
 * @version 1.0
 * @description: TODO Set接口
 * @date 2021/7/21 0:29
 */
public class SetTest {


    @Test
    public void test1(){
        HashSet set = new HashSet();
        set.add(123);
        set.add(345);
        set.add("AA");
        set.add("BB");
        set.add("fxf");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            //输出结果
            // AA
            //BB
            //fxf
            //345
            //123
        }
    }

    /**
     * LinkedHashSet的使用，LinkedHashSet作为HashsSet的子类，在添加数据的同时，每个数据还维护了两个引用，记录此数据的前一个和后一个数据
     *
     * 有点：对比频繁的遍历操作，LikendHashSet效率要高于HashSet
     */
    @Test
    public void test2(){
        Set set = new LinkedHashSet();
        set.add(123);
        set.add(345);
        set.add("AA");
        set.add("BB");
        set.add("fxf");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            //输出结果
            // AA
            //BB
            //fxf
            //345
            //123
        }
    }

    @Test
    public void treeSetTest(){
        TreeSet treeSet = new TreeSet();

        //TreeSet不能添加不同类的对象
        treeSet.add(123);
        treeSet.add(435);
//        treeSet.add("AA");

    }

    @Test
    public void treeSetTest1(){


        //自定义排序规则
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    User u1 = (User)o1;
                    User u2 = (User)o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }else {
                    throw new RuntimeException("输入的数据类型不匹配");
                }
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };
        TreeSet treeSet = new TreeSet(com);
        treeSet.add(new User("Tom",29));
        treeSet.add(new User("jerry",18));
        treeSet.add(new User("jack",20));
        treeSet.add(new User("mike",33));
        treeSet.add(new User("Tom",29));
        treeSet.add(new User("jim",15));
        treeSet.add(new User("merry",19));
        treeSet.add(new User("txt",25));

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }

    }
}
