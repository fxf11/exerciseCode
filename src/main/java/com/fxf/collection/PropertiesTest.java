package com.fxf.collection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/7/25 22:17
 */
public class PropertiesTest {

    /**
     * Properties:常用来处理配置文件，key和value都是String类型
     */
    public static void main(String[] args) {
        Properties pro = new java.util.Properties();
        FileInputStream file = null;
        try {
            file = new FileInputStream("jdbc.properties");
            //加载流对应的文件
            pro.load(file);

            String name = pro.getProperty("name");
            System.out.println(name);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
