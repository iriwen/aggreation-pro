package com.manjaro.cache;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.CacheKeyPrefix;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.format.support.DefaultFormattingConversionService;

import java.time.Duration;

/**
 * created by iriwen on 2021/06/08.
 */

@Configuration
public class RedisConfig {

    @Bean
    @Qualifier("cacheRedisProperties")
    @ConfigurationProperties(prefix = "spring.redis")
    public RedisProperties cacheRedisProperties() {
        return new RedisProperties();
    }

    @Bean
    @Qualifier("cacheFactory")
    public LettuceConnectionFactory cacheRedisConnectionFactory(RedisProperties redisProperties) {
        if (redisProperties != null) {
            RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration(redisProperties.getCluster().getNodes());
            redisClusterConfiguration.setPassword(redisProperties.getPassword());
            redisClusterConfiguration.setMaxRedirects(redisProperties.getCluster().getMaxRedirects());
            return new LettuceConnectionFactory(redisClusterConfiguration, getLettuceClientConfiguration(redisProperties));
        }
        return null;
    }

    public LettuceClientConfiguration getLettuceClientConfiguration(RedisProperties redisProperties) {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();

        poolConfig.setMaxTotal(redisProperties.getLettuce().getPool().getMaxActive());
        poolConfig.setMaxIdle(redisProperties.getLettuce().getPool().getMaxIdle());
        poolConfig.setMinIdle(redisProperties.getLettuce().getPool().getMinIdle());
        poolConfig.setMaxWaitMillis(redisProperties.getLettuce().getPool().getMaxWait().toMillis());

        return LettucePoolingClientConfiguration.builder()
                .commandTimeout(redisProperties.getTimeout())
                .poolConfig(poolConfig).build();
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }

    RedisCacheConfiguration getCacheConfigurationWithTtl(RedisTemplate<String, Object> redisTemplate, long seconds) {

        RedisSerializer<String> stringSerializer = redisTemplate.getStringSerializer();
        RedisSerializationContext.SerializationPair<String> stringSerializationPair = RedisSerializationContext.SerializationPair.fromSerializer(stringSerializer);

        RedisSerializer<?> valueSerializer = redisTemplate.getValueSerializer();
        RedisSerializationContext.SerializationPair<?> valueSerializationPair = RedisSerializationContext.SerializationPair.fromSerializer(valueSerializer);
        return RedisCacheConfiguration.defaultCacheConfig() //先获取redisconfig的默认配置
                // 设置key为String
                .serializeKeysWith(stringSerializationPair)
                // 设置value为自动转Json的Object
                .serializeValuesWith(valueSerializationPair)
                // 不缓存null
                .disableCachingNullValues()
                // 缓存数据保存1小时
                .entryTtl(Duration.ofSeconds(seconds));
    }

    @Bean
    public CacheManager cacheManager(RedisTemplate<String, Object> redisTemplate) {

        RedisCacheManager.RedisCacheManagerBuilder redisCacheManagerBuilder = org.springframework.data.redis.cache.RedisCacheManager.RedisCacheManagerBuilder
                .fromConnectionFactory(redisTemplate.getConnectionFactory())
                .cacheDefaults(getCacheConfigurationWithTtl(redisTemplate, 60 * 60));

        //将有时间限制的缓存的依次添加到cacheManager中管理
        for (CacheDurationConfig cacheConfig : CacheDurationConfig.cacheConfigs()) {
            redisCacheManagerBuilder.withCacheConfiguration(cacheConfig.getName(),getRedisCacheConfig(cacheConfig,redisTemplate));
        }

       RedisCacheManager redisCacheManager = redisCacheManagerBuilder.transactionAware().build();

       RedisCacheManager redisCacheManager2 = RedisCacheManager.RedisCacheManagerBuilder
                // Redis 连接工厂
                .fromConnectionFactory(redisTemplate.getConnectionFactory())
                .cacheDefaults(getCacheConfigurationWithTtl(redisTemplate, 60 * 60))

                .withCacheConfiguration("cache_user", getCacheConfigurationWithTtl(redisTemplate, 60))
                .withCacheConfiguration("cache_post", getCacheConfigurationWithTtl(redisTemplate, 120))
                // 配置同步修改或删除 put/evict
                .transactionAware()
                .build();

       return redisCacheManager ;

       /* // 基本配置
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
                .build();*/

        //return redisCacheManager2;
    }

    public  RedisCacheConfiguration getRedisCacheConfig(CacheDurationConfig cacheConfig,RedisTemplate<String, Object> redisTemplate) {

        RedisSerializer<String> stringSerializer = redisTemplate.getStringSerializer();
        RedisSerializationContext.SerializationPair<String> stringSerializationPair = RedisSerializationContext.SerializationPair.fromSerializer(stringSerializer);

        RedisSerializer<?> valueSerializer = redisTemplate.getValueSerializer();
        RedisSerializationContext.SerializationPair<?> valueSerializationPair = RedisSerializationContext.SerializationPair.fromSerializer(valueSerializer);

        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig() //先获取redisconfig的默认配置
                // 设置key为String
                .serializeKeysWith(stringSerializationPair)
                // 设置value为自动转Json的Object
                .serializeValuesWith(valueSerializationPair)
                // 不缓存null
                .disableCachingNullValues()
                // 缓存数据保存1小时
                .entryTtl(Duration.ofMinutes(cacheConfig.getExpire() * 60));

        return redisCacheConfiguration ;

    }
}
