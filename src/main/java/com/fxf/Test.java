package com.fxf;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/8/7 16:05
 */
public class Test {

    String str = new String("good");
    char[] ch = {'a','b','c'};

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Test test = new Test();
        test.change(test.str,test.ch);
        System.out.println(test.str+"and");
        System.out.println(test.ch);

        Integer a = 12; Integer b = 12;
        Integer c = 316; Integer d = 316;
        Class declaredClass = Integer.class.getDeclaredClasses()[0];
        Field cache = declaredClass.getDeclaredField("cache");
        cache.setAccessible(true);

        Integer[] new_cache = (Integer[])cache.get(declaredClass);
        new_cache[130] = new_cache[129];

        Integer res = 1+1;
        System.out.println("1+1="+res);
    }
    public void change(String str,char ch[]){
//        str = "test ok";
        ch[0] = 'g';
    }

    @org.junit.Test
    public void test(){
        int a=0;
        int b = 0;
        do{
            --b;
            a=a-1;

        }while (a>0);
        System.out.println(b);
    }

    @org.junit.Test
    public List<String> test3(Integer Str_length, Integer Count){

        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        ArrayList<String> list = new ArrayList<>(Count);
        for (int i = 0; i < Count; i++) {

            for(int j=0;j<Str_length;j++){
                int number=random.nextInt(62);
                sb.append(str.charAt(number));
            }
            list.add(sb.toString());

        }

        return list;

    }

    @org.junit.Test
    public String test4(String str){

        String s=str.toUpperCase();
        StringBuilder sb=new StringBuilder();
        List<Integer> list=new ArrayList<>();
        list.add(0);
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)!=s.charAt(i-1)){
                list.add(i);
            }
        }
        for(Integer n:list){
            sb.append(str.charAt(n));
        }
        return sb.toString();

    }



}

abstract class ces{
    public abstract void ces();
}
