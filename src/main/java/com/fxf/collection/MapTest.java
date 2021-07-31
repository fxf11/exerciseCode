package com.fxf.collection;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 *
 * Map：双列数据，存储key-value对的数据
 *      HashMap：作为Map的主要实现类；线程不安全效率高，key\value可以为null
 *          LinkedHashMap:保证在遍历map元素时，可以按照添加的顺序实现遍历
 *             原因：在原有的hashMap底层结构基础上，添加了一对指针，只想前一个和后一个
 *             对于频繁的遍历操作，此类执行效率高于HashMap
 *      TreeMap：包装按照添加的key-value键值对惊醒排序，实现排序遍历
 *      HashTable：比较古老的实现类，jdk1.2就存在，线程安全；效率低，key、value不能为null
 *          Properties：常用来处理配置文件。key-value都是String类型
 *
 *
 * Map结构：
 *      key-value键值对：无序的，key不可重复value可重复，key-value构成一个entry对象，key使用Set存储
 *      map中的entry是无序的、不可重复的、使用Set存储所有的entry
 *
 * HashMap底层：
 *      jdk1.7及以前是使用数组+链表，jdk1.8之后又加入了红黑树
 *
 * 实现原理：
 *      jdk7：
 *          在new HashMap()实例化后，底层创建了一个长度是16的一位数组Entry[] table,
 *          map.put(key1,value1);,首先调用key1所在类的hashCode()计算key1哈希值，此哈希值经过某种算法计算以后，得到在Entry中的存放位置，
 *          如果此位置上的数据添加成功，则添加成功，如果此位置的数据部位空则意味着这个位置存在一个或则多个以链表形式的数据，这样的话会再次与
 *          这个位置已经存在的数据的哈希值惊醒比较，如果都不相同，则依然添加成功，如果有相同的，继续调用key1所在类的equals()方法，如果为false，则
 *          添加成功，如果返回true则会把比较的这个key的value值更新为value1
 *
 *          关于key和已经存在的数据的哈希值不相同以及哈希值相同但equals()比较不相同的情况，此时key1-value1会和原来的数据以链表的方式存储
 *
 *          在不断对map进行put操作，当map中存储的数据的长度过多时会触发默认的扩容机制，默认扩容为原来的两倍，并复制原有数据
 *
 *      jdk8相较于jdk1.7：
 *          new HashMap创建实例的时候底层没有直接去创建一个长度为16的数组
 *          jdk8底层的数组时Node[]而并非Entry[],
 *          首次调用put方法时底层才创建长度为16的数组
 *          jdk7的底层数据结构为：数组+链表 jdk8中为数组+链表+红黑树
 *              当数组的某一个索引位置上的链表形式的数据个数 > 8 且当前数组的长度 > 64，此时该索引位置上的所有数据会改为红黑树存储
 *
 *      HashMap源码常见变量：
 *          DEFAULT_INITIAL_CAPACITY:HashMap的默认容量，16
 *          MAXIMUM_CAPCITY:HashMap的最大支持容量，2^30
 *          TREEIFY_THRESHOLD：BUcket桶中链表长度大于该默认值，转化为红黑树
 *          UNTREEIFY——THRESHOLD：BUCKET中红黑树存储的NODE小于该默认值，转化为链表
 *          MIN_TREEIFY_CAPACITY:桶中NODE被书画时最小的hash表容量
 *
 *          table：存储元素的数组，总是2的n次幂
 *          entrySet：存储具体元素的集
 *          size：hashMap中存储的键值对的数量
 *          modCount：HashMap扩容和结构改变的次数。
 *          threshold：扩容的临界值，=容量*填充因子
 *          loadFactor:填充因子
 *
 *
 * Map中常用方法00
 *
 *
 * @author 饭小范
 * @version 1.0
 * @description: TODO map测试类
 * @date 2021/7/22 0:16
 */
public class MapTest {

    /**
     * Map遍历
     */
    @Test
    public void test4(){

        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("s",123);

        Map hashMap = new HashMap();
        hashMap.put("AA",123);
        hashMap.put("BB",123);
        hashMap.put("CC",324);

        Set set = hashMap.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //遍历所有的value
        Collection values = hashMap.values();
        for (Object value : values) {
            System.out.println(value);
        }
    }

    @Test
    public void test3(){
        Map hashMap = new HashMap();
        hashMap.put("AA",123);
        hashMap.put("BB",123);
        hashMap.put("CC",324);

        boolean aa = hashMap.containsKey("AA");
        System.out.println(aa);
        boolean b = hashMap.containsValue(123);
        System.out.println(b);
    }

    @Test
    public void test2(){
        Map hashMap = new LinkedHashMap();
        hashMap.put(123,"AA");
        hashMap.put(345,"BB");
        hashMap.put(56,"CC");
        System.out.println(hashMap);

    }


    @Test
    public void test1(){

        HashMap hashMap = new HashMap();
        hashMap.put(1,"ces");
        hashMap.put(1,"cesx");
        System.out.println(hashMap.get(1));

    }
}
