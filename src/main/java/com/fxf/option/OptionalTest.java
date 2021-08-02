package com.fxf.option;

import org.junit.Test;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/7/31 15:34
 */
public class OptionalTest {

    /**
     * Optional,of(T t)：创建一个Optional实例，t必须非空
     *
     */
    @Test
    public void test1(){

        Gril gril = new Gril();
        gril = null;
        Optional<Gril> gril1 = Optional.of(gril);
    }

    @Test
    public void test2(){

        Gril gril = new Gril();
//        gril = null;
        Optional<Gril> gril1 = Optional.ofNullable(gril);
        System.out.println(gril1);
    }

    public String getGrilName1(Boy boy){
        if (boy != null){
            Gril gril = boy.getGril();
            if (gril != null){
                return gril.getName();
            }
        }
        return null;
    }

    @Test
    public void test3(){

        Boy boy = new Boy();
        String grilName1 = getGrilName1(boy);
        System.out.println(grilName1);
    }
}
