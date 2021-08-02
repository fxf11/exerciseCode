package com.fxf.reflection.proxy;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO 静态代理举例
 * @date 2021/7/29 0:33
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nikeClothFactory);
        proxyClothFactory.produceCloth();
    }
}

interface ClothFactory{

    void produceCloth();
}

class ProxyClothFactory implements ClothFactory{

    //被代理类对象进行实例化
    private ClothFactory clothFactory;

    public ProxyClothFactory(ClothFactory clothFactory){
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        clothFactory.produceCloth();
        System.out.println("代理工程做一些后续的工作");
    }
}

//被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂圣餐一批运动服");
    }
}

