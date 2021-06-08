package com.manjaro.tools.spring.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

/**
 * created by iriwen on 2021/02/26.
 */
@Slf4j
public class MySpringAppEvent extends ApplicationEvent {

    private String msg;

    /**
     */
    public MySpringAppEvent(Object source) {
        super(source);
    }

    public MySpringAppEvent(Object source, String msg) {
        super(source);
        log.info("event publish source :{}",source.getClass());
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
