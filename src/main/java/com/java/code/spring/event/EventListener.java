package com.java.code.spring.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * created by iriwen on 2021/05/25.
 */
@Slf4j
@Component
public class EventListener  implements ApplicationListener<MySpringAppEvent> {

    @Override
    public void onApplicationEvent(MySpringAppEvent event) {
        log.info("monitor event  occured ! :{}", new Date());
    }
}

