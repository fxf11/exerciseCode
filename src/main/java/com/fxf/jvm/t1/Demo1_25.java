package com.fxf.jvm.t1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/6/29 21:13
 */
public class Demo1_25 {
    public static void main(String[] args) throws IOException {

        ArrayList<String> address = new ArrayList<>();
        System.in.read();
        for (int i = 0; i < 10; i++) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("linux.words"),"utf-8"))){
                String line = null;
                long start = System.nanoTime();
                while (true){
                    line = reader.readLine();
                    if (line == null){
                        break;
                    }
                    address.add(line);
                }
                System.out.println("cost:"+(System.nanoTime() -start) / 100000);
            }
        }
        System.in.read();
    }
}
