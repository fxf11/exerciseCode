package com.fxf;

import com.fxf.event.DemoEvent;
import com.fxf.pojo.Users;
import com.fxf.service.MailServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;


import java.lang.invoke.MethodHandle;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy
public class RegularMailApplication {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        System.out.println(ac.getBean(Users.class));
//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("com.fxf.aspect");
//        annotationConfigApplicationContext.getBean(Users.class);

 SpringApplication.run(RegularMailApplication.class, args);
//        DemoEvent world = new DemoEvent("", "world");
//        run.publishEvent(world);
//
//        Class<Users> usersClass = Users.class;
//
//        test(usersClass);



    }

    private static void test(Class<?> clazz) throws IllegalAccessException, InstantiationException {
        Users o = (Users) clazz.newInstance();
        o.getId();

    }

}
