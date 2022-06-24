package com.manjaro.code;

import com.manjaro.code.interceptor.MyReqInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * created by iriwen on 2020/04/02.
 * 启用缓存
 */
@SpringBootApplication
@EnableCaching
@Import(com.manjaro.cache.RedisConfig.class)
@MapperScan("com.manjaro.code.mapper")
public class ManjaroApp implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(ManjaroApp.class, args);
    }

    @Bean
    public MyReqInterceptor myReqInterceptor() {
        return new MyReqInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myReqInterceptor()).addPathPatterns("/lazy/*");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowedMethods("*");
    }

}
