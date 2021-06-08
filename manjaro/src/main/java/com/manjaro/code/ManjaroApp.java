package com.manjaro.code;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;

/**
 * created by iriwen on 2020/04/02.
 * 启用缓存
 */
@SpringBootApplication
@EnableCaching
@Import(com.manjaro.cache.RedisConfig.class)
@MapperScan("com.manjaro.code.mapper")
public class ManjaroApp {
    public static void main(String[] args) {
        SpringApplication.run(ManjaroApp.class, args);
    }
}
