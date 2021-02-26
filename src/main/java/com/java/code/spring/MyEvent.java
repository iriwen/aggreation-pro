package com.java.code.spring;

import org.springframework.context.ApplicationEvent;

/**
 * created by yuxiaodong01 on 2021/02/26.
 */
public class MyEvent extends ApplicationEvent {

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public MyEvent(Object source) {
        super(source);
    }
}
