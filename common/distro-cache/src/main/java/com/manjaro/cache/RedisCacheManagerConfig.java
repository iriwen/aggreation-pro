package com.manjaro.cache;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.time.Duration;

/**
 * created by iriwen on 2021/06/08.
 */

@Configuration
public class RedisCacheManagerConfig {

    @Bean
    public CacheManager cacheManager(RedisTemplate<String, Object> redisTemplate) {

        RedisSerializer<String> stringSerializer = redisTemplate.getStringSerializer();
        RedisSerializationContext.SerializationPair<String> stringSerializationPair = RedisSerializationContext.SerializationPair.fromSerializer(stringSerializer);

        RedisSerializer<?> valueSerializer = redisTemplate.getValueSerializer();
        RedisSerializationContext.SerializationPair<?> valueSerializationPair = RedisSerializationContext.SerializationPair.fromSerializer(valueSerializer);

        // 基本配置
        RedisCacheConfiguration defaultCacheConfiguration = RedisCacheConfiguration
                        .defaultCacheConfig()
                        // 设置key为String
                        .serializeKeysWith(stringSerializationPair)
                        // 设置value 为自动转Json的Object
                        .serializeValuesWith(valueSerializationPair)
                        // 不缓存null
                        .disableCachingNullValues()
                        // 缓存数据保存1小时
                        .entryTtl(Duration.ofHours(1));

        // 够着一个redis缓存管理器
        RedisCacheManager redisCacheManager = RedisCacheManager.RedisCacheManagerBuilder
                        // Redis 连接工厂
                        .fromConnectionFactory(redisTemplate.getConnectionFactory())
                        // 缓存配置
                        .cacheDefaults(defaultCacheConfiguration)
                        // 配置同步修改或删除 put/evict
                        .transactionAware()
                        .build();

        return redisCacheManager;
    }

}
