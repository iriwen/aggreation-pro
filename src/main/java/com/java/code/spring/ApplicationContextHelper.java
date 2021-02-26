package com.java.code.spring;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * created by yuxiaodong01 on 2021/02/26.
 */

@Component
public class ApplicationContextHelper implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
        System.out.println("context  was configed");
    }
}
