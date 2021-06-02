package com.java.code.executor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.websocket.RemoteEndpoint;

/**
 * created by yuxiaodong01 on 2021/06/02.
 */
@Service
@Slf4j
public class AsyncServiceImpl implements AsyncService {

    @Override
    @Async("asyncServiceExecutor")
    public void executeAsync() {
        log.info("start executeAsync");

        log.info("异步线程要做的事情");
        log.info("可以在这里执行批量插入等耗时的事情");

        log.info("end executeAsync");
    }
}
