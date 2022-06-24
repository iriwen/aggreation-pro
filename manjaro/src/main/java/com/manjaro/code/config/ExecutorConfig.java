package com.manjaro.code.config;

import com.manjaro.code.executor.VisiableThreadPoolTaskExecutor;
import com.manjaro.code.mapper.PopuBaseMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * created by iriwen on 2021/06/02.
 */


@Configuration
@EnableAsync
@ConfigurationProperties(prefix = "async.executor")
@Data
@Slf4j
public class ExecutorConfig {

    //配置类中注入mapper
    //@Autowired
    private PopuBaseMapper popuBaseMapper ;

    //@Value("${async.executor.corePoolSize}")
    public int corePoolSize;

    //@Value("${async.executor.maxPoolSize}")
    public int maxPoolSize;

    //@Value("${async.executor.queueCapacity}")
    public int queueCapacity;

    //@Value("${async.executor.namePrefix}")
    public String namePrefix;

    @Bean("asyncServiceExecutor")
    public Executor asyncServiceExecutor() {

        /*if(popuBaseMapper  instanceof FactoryBean){
            log.info(popuBaseMapper.toString());
        }*/
        //在这里修改
        ThreadPoolTaskExecutor executor = new VisiableThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(corePoolSize);
        //配置最大线程数
        executor.setMaxPoolSize(maxPoolSize);
        //配置队列大小
        executor.setQueueCapacity(queueCapacity);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix(namePrefix);

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化线程池动作
        executor.initialize();
        return executor;
    }
}
