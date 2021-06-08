package com.manjaro.cache;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * 如果只是简单的使用Spring Cache，可以继承该类，实现redisTemplate()，并添加@Bean即可
 * 如果需要单个服务内，不同业务使用不同的NCR实例，则需自行override cacheManager()方法
 */
public abstract class RedisCacheConfigurerSupport extends CachingConfigurerSupport {

    @Bean
    public abstract RedisTemplate<String, Object> redisTemplate();

    /*@Bean
    public abstract CachePrefixGetter cachePrefixGetter();*/

    @Bean
    @Override
    @Primary
    public CacheManager cacheManager() {
        RedisCacheManager manager = new RedisCacheManager();
        List<RedisCache> redisCacheList = new ArrayList<>();
        for (CacheDurationConfig cacheDurationConfig : CacheDurationConfig.cacheConfigs()) {
            //redisCacheList.add();
        }
        manager.setCaches(redisCacheList);
        return manager;
    }

    @Bean
    @Override
    public CacheErrorHandler errorHandler() {
        //Spring Cache默认使用的是SimpleCacheErrorHandler，会抛出所有异常，不合理，会在缓存服务有问题时导致服务失败
        return new LogTracerCacheErrorHandler();
    }

    @Override
    public KeyGenerator keyGenerator() {
        return new SimpleKeyGenerator();
    }

    @Bean
    public Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer() {

        final Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);

        final ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();

        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);

        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

       /* Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        serializer.setObjectMapper(objectMapper);*/

        return jackson2JsonRedisSerializer;
    }
}
