package com.manjaro.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheErrorHandler;

public class LogTracerCacheErrorHandler implements CacheErrorHandler {

    private static final Logger logger = LoggerFactory.getLogger(com.manjaro.cache.LogTracerCacheErrorHandler.class);

    @Override
    public void handleCacheGetError(RuntimeException e, Cache cache, Object o) {
        logger.error("com.manjaro.cache get error, com.manjaro.cache = {}, key = {}", cache.getName(), o, e);
    }

    @Override
    public void handleCachePutError(RuntimeException e, Cache cache, Object o, Object o1) {
        logger.error("com.manjaro.cache put error, com.manjaro.cache = {}, key = {}", cache.getName(), o, e);
    }

    @Override
    public void handleCacheEvictError(RuntimeException e, Cache cache, Object o) {
        logger.error("com.manjaro.cache evict error, com.manjaro.cache = {}, key = {}", cache.getName(), o, e);
    }

    @Override
    public void handleCacheClearError(RuntimeException e, Cache cache) {
        logger.error("com.manjaro.cache clear error, com.manjaro.cache = {}", cache.getName(), e);
    }
}
