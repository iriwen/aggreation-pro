package com.manjaro.cache;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * Created by lc on 2019/08/14.
 */
//@Configuration
//@EnableRedisCaching
//@ConditionalOnClass({LettuceConnection.class, RedisOperations.class})
//@EnableAutoConfiguration(exclude = {RedisAutoConfiguration.class, RedisReactiveAutoConfiguration.class})
//@Slf4j
public class CacheRedisConfiguration extends CachingConfigurerSupport {

    /*@Bean
    @Qualifier("cacheRedisProperties")
    @ConfigurationProperties(prefix = "redis.cache")
    public RedisProperties cacheRedisProperties() {
        return new RedisProperties();
    }*/

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

	public  LettuceClientConfiguration getLettuceClientConfiguration(RedisProperties redisProperties) {

    	GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();

		poolConfig.setMaxTotal(redisProperties.getLettuce().getPool().getMaxActive());
		poolConfig.setMaxIdle(redisProperties.getLettuce().getPool().getMaxIdle());
		poolConfig.setMinIdle(redisProperties.getLettuce().getPool().getMinIdle());
		poolConfig.setMaxWaitMillis(redisProperties.getLettuce().getPool().getMaxWait().toMillis());

		return LettucePoolingClientConfiguration.builder()
				.commandTimeout(redisProperties.getTimeout())
				.poolConfig(poolConfig).build();
	}

   /* @Bean
    @Qualifier("cacheRedisTemplate")
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        Jackson2JsonRedisSerializer<Object> serializer = jackson2JsonRedisSerializer();
        redisTemplate.setConnectionFactory(cacheRedisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(serializer);
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(serializer);
        return redisTemplate;
    }*/

   /* @Bean
    public CacheManager localCacheManager() {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        List<CaffeineCache> cacheList = Lists.newArrayList();
        for (GuavaCacheConfig cacheConfig : GuavaCacheConfig.caches) {
            cacheList.add(
                    new CaffeineCache(
                            cacheConfig.getName(),
                            Caffeine.newBuilder()
                                    .recordStats()
                                    .expireAfterWrite(cacheConfig.getTtl(), TimeUnit.SECONDS)
                                    .maximumSize(cacheConfig.getMaxSize())
                                    .build(), cacheConfig.isCacheNull()) {
                        @Override
                        public void put(Object key, Object value) {
                            if (value != null || this.isAllowNullValues()) {
                                super.put(key, value);
                            }
                        }

                        @Override
                        protected Object toStoreValue(Object userValue) {
                            if (userValue == null) {
                                if (this.isAllowNullValues()) {
                                    return NullValue.INSTANCE;
                                }
                            }
                            return userValue;
                        }
                    });
        }
        simpleCacheManager.setCaches(cacheList);
        return simpleCacheManager;
    }*/


	@Bean
	public Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer() {
		final Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
		final ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();

		objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);

		objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

		jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

		return jackson2JsonRedisSerializer;
	}

}
