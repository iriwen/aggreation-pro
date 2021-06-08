package com.manjaro.spring;

import com.manjaro.spring.event.EventConfig;
import com.manjaro.spring.event.EventsPublisher;
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
