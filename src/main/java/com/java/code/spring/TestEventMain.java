package com.java.code.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * created by yuxiaodong01 on 2021/05/25.
 */
public class TestEventMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(EventConfig.class);
        EventsPublisher demoPublisher = applicationContext.getBean(EventsPublisher.class);
        demoPublisher.publish("我来发布消息");
        applicationContext.close();
    }
}
