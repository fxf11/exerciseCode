package com.fxf;


import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.openjdk.jol.util.IOUtils;

/**
 * @Description TODO 布隆过滤器
 * @Author Administrator
 * @Date 2021/8/18 8:42
 * @Version 1.0
 */
public class BloomFilterTest {

    private static int size = 1000000;//预计要插入多少数据
    private static double fpp = 0.00001;//预期的误判率

    private static BloomFilter<Integer> bloomFilter =  BloomFilter.create(Funnels.integerFunnel(), size, fpp);

    public static void main(String[] args) {

        IOUti
        //插入数据

        for (int i = 0; i < 1000000; i++) {
            bloomFilter.put(i);
        }
        int count = 0;

        for (int i = 1000000; i < 2000000; i++) {
            if (bloomFilter.mightContain(i)){
                count++;
                System.out.println(i + "误判了");
            }
        }
        System.out.println("误判总数："+count);
    }

}
