package com.fxf.jvm.t1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/6/29 20:49
 */
public class Demo1_24 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("linux.words"),"utf-8"))){
            String line = null;
            long start = System.nanoTime();
            while (true){
                line = reader.readLine();
                if (line == null){
                    break;
                }
            }
            System.out.println("cost:"+(System.nanoTime() -start) / 100000);



        }
    }
}
