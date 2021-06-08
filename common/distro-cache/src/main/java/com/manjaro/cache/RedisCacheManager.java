package com.manjaro.cache;

import org.springframework.cache.support.AbstractCacheManager;
import org.springframework.data.redis.cache.RedisCache;

import java.util.Collection;

/**
 * spring cache自带的RedisCacheManager不能使用NCR（NCR不支持Transaction)，因此用接口自己封装一个
 */
public class RedisCacheManager extends AbstractCacheManager {

    private Collection<? extends RedisCache> caches;

    public void setCaches(Collection<? extends RedisCache> caches) {
        this.caches = caches;
    }


    @Override
    protected Collection<? extends RedisCache> loadCaches() {
        return this.caches;
    }
}
