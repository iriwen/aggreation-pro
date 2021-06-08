package com.manjaro.tools.spring;

import com.manjaro.tools.spring.event.EventConfig;
import com.manjaro.tools.spring.event.EventsPublisher;
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
