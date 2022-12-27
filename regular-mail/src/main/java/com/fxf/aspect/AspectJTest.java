package com.fxf.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Classname AspectJTest
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/3/25 21:49
 * @Created by 饭小范
 */
@Aspect
@Component
public class AspectJTest {

    @Pointcut("execution(public * com.fxf.service.MailService.sentMail(..))")
    public void testAOP(){}

    @Before("testAOP()")
    public void before(){
        System.out.println("before testAOP...");
    }

    @After("testAOP()")
    public void after(){
        System.out.println("after testAOP...");
    }

    @Around("testAOP()")
    public Object around(ProceedingJoinPoint p){
        System.out.println("around before testAOP...");
        Object o = null;
        try {
            o = p.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("around after testAOP...");
        return o;
    }

}
