package com.java.code.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * created by yuxiaodong01 on 2020/06/27.
 */
public class LogHandler  implements InvocationHandler {

    //被代理的目标对象
    private final Object target;

    private final MyAdvisor myAdvisor = new MyAdvisor();

    public LogHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        myAdvisor.beforeLogAdvice();
        Object result  = method.invoke(target, args);
        myAdvisor.afterLogAdvice();
        System.out.println(target.getClass().getName()+ " : " + target.getClass().hashCode());
        System.out.println(proxy.getClass().getName()+ " : " + proxy.getClass().hashCode());

        return result;
    }

}
