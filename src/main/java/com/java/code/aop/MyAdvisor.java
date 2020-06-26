package com.java.code.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * created by yuxiaodong01 on 2020/06/26.
 */
public class MyAdvisor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        System.out.println("before  invoke  method ");

        //沿着拦截器链传到下一个
        Object result = methodInvocation.proceed();

        System.out.println("after  invoke  method ");

        return result;
    }
}
