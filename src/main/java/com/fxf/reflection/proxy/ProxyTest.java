package com.fxf.reflection.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 动态代理
 * @date 2021/7/29 0:40
 */
public class ProxyTest {

    public static void main(String[] args) {

        SuperMan superMan = new SuperMan();
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("火锅");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory clothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        clothFactory.produceCloth();

    }
}

interface Human{
    String getBelief();

    void eat(String food);
}


//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "我相信我能飞";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

//代理类
class ProxyFactory{

    /**
     * 调用此方法，返回一个代理类的对象，动态的创建代理类及其对象
     */
    public static Object getProxyInstance(Object obj){
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);


        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);

    }
}

class MyInvocationHandler implements InvocationHandler{

    //需要使用被代理类的对象进行复制
    private Object object;

    public void bind(Object obj){
        this.object = obj;
    }

    /**
     * 当我们通过代理类对象，调用方法a时，就会自动的调用如下的方法
     * 将被代理类要执行的方法a的功能就声明在invoke()中
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(object, args);
        return invoke;
    }
}
