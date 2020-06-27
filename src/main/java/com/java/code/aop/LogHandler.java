package com.java.code.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * created by yuxiaodong01 on 2020/06/27.
 */
public class LogHandler  implements InvocationHandler {

    //被代理的目标对象
    private final Object target;

    public LogHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        beforeLog();
        Object result  = method.invoke(target, args);
        afterLog();
        System.out.println(target.getClass().getName()+ " : " + target.getClass().hashCode());
        System.out.println(proxy.getClass().getName()+ " : " + proxy.getClass().hashCode());

        return result;
    }

    /*
    *
    * 前置通知
    */
    private void beforeLog(){
        System.out.println("log before ....");
    }

    /*
     * 后置通知
     */
    private void afterLog(){
        System.out.println("log after ....");
    }
}
