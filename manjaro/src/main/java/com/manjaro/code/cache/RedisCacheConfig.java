package com.manjaro.code.cache;

import org.springframework.cache.annotation.AnnotationCacheOperationSource;
import org.springframework.cache.interceptor.CacheInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//@Configuration
public class RedisCacheConfig  {
    //public class RedisProxyCachingConfiguration extends ProxyCachingConfiguration {

    @Bean
    //@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public CacheInterceptor cacheInterceptor() {
        CacheInterceptor interceptor = new RedisCacheInterceptor();
        interceptor.setCacheOperationSources(new AnnotationCacheOperationSource());
        /*if (this.cacheResolver != null) {
            interceptor.setCacheResolver(this.cacheResolver.get());
        } else if (this.cacheManager != null) {
            interceptor.setCacheManager(this.cacheManager.get());
        }
        if (this.keyGenerator != null) {
            interceptor.setKeyGenerator(this.keyGenerator.get());
        }
        if (this.errorHandler != null) {
            interceptor.setErrorHandler(this.errorHandler.get());
        }*/
        return interceptor;
    }
}
