package code.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * created by iriwen on 2020/06/26.
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

    /*
     *
     * 前置通知
     */
    public void beforeLogAdvice(){
        System.out.println("log before ....");
    }

    /*
     * 后置通知
     */
    public void afterLogAdvice(){
        System.out.println("log after ....");
    }
}
