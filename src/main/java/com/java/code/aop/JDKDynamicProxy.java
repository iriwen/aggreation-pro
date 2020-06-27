package com.java.code.aop;

import java.lang.reflect.Proxy;

/**
 * created by yuxiaodong01 on 2020/06/27.
 */
public class JDKDynamicProxy {

    public static void main(String[] args) {

        MyAopServiceImpl serviceAopImpl = new MyAopServiceImpl();

        LogHandler logHandler = new LogHandler(serviceAopImpl);
        //jdk动态代理两个核心组件  Proxy 和 InvocationHandler（需要自己在实现类里重写invoke方法）
        MyAopService myAopService = (MyAopService) Proxy.newProxyInstance(JDKDynamicProxy.class.getClassLoader(),
                serviceAopImpl.getClass().getInterfaces(), logHandler);

        System.out.println(myAopService.getClass().getName() + "; hash 值 ：" + myAopService.getClass().hashCode());

        myAopService.method();

    }

}
