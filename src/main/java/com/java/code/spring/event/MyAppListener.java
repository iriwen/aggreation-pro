package com.java.code.spring.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * created by iriwen on 2021/02/26.
 */
@Component
@Slf4j
public class MyAppListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        ApplicationContext ctx = event.getApplicationContext();

        log.info("context refreshed ... {}",event.getClass());
    }
}
