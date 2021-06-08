package com.java.code.spring;

import com.java.code.spring.event.EventConfig;
import com.java.code.spring.event.EventsPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * created by iriwen on 2021/05/25.
 */
public class SpringEventTestClient {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(EventConfig.class);
        EventsPublisher demoPublisher = applicationContext.getBean(EventsPublisher.class);
        demoPublisher.publish("我来发布消息");
        applicationContext.close();
    }
}
