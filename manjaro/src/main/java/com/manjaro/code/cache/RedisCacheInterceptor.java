package com.manjaro.code.cache;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cache.interceptor.CacheInterceptor;

/**
 * @see CacheInterceptor
 */
public class RedisCacheInterceptor extends CacheInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        //RedisCacheThreadLocal.invocationThreadLocal.set(invocation);
        System.out.println("cache  intercept  in  ...");
        return super.invoke(invocation);
    }

}
