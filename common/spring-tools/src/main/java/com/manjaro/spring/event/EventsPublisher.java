package com.manjaro.spring.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * created by iriwen on 2021/05/25.
 */

@Component
public class EventsPublisher {

    @Autowired
    ApplicationContext applicationContext;

    public void publish(String msg) {
        applicationContext.publishEvent(new MySpringAppEvent(this, msg));
    }
}