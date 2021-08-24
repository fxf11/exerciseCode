package com.fxf.starterdemo.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/8/24 22:37
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserService {

    String name;
    Integer age;


    public String test(){
        System.out.println("name"+name+"\t\tage"+age);
        return "this is test method";
    }
}
