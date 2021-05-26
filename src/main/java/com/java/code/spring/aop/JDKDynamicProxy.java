package com.java.code.spring.aop;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Proxy;

/**
 * created by yuxiaodong01 on 2020/06/27.
 */
@Slf4j
public class JDKDynamicProxy {

    public static void main(String[] args) {

        MyAopServiceImpl serviceAopImpl = new MyAopServiceImpl();

        LogHandler logHandler = new LogHandler(serviceAopImpl);
        //jdk动态代理两个核心组件  Proxy 和 InvocationHandler（需要自己在实现类里重写invoke方法）
        MyAopService myAopService = (MyAopService) Proxy.newProxyInstance(JDKDynamicProxy.class.getClassLoader(),
                serviceAopImpl.getClass().getInterfaces(), logHandler);

        log.info("当前从ioc容器中获取的对象：{}; hash值：{}",myAopService.getClass(),myAopService.getClass().hashCode());


        if(myAopService instanceof  MyAopService){
            log.info("......对象类型是MyAopService");
        }

        myAopService.method();

    }

}
