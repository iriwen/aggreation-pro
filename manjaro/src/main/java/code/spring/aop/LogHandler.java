package code.spring.aop;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * created by iriwen on 2020/06/27.
 */
@Slf4j
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
        if(proxy instanceof MyAopServiceImpl ) {
            log.info("方法内的proxy对象也是 。。。。。");
        }

        return result;
    }

}
