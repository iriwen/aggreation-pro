package com.manjaro.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * created by iriwen on 2021/06/08.
 */
public class CacheDurationConfig {

    public static final String MINUTE_30 = "MINUTE_30";
    public static final String HOUR_1 = "HOUR_1";
    public static final String HOUR_12 = "HOUR_12";

    public static final String DAY_1 = "DAY_1";
    public static final String DAY_7 = "DAY_7";
    public static final String DAY_30 = "DAY_30";

    public static final String FOREVER = "FOREVER";


    public static final String MINUTE_30_CACHE_NULL = "MINUTE_30_CACHE_NULL";
    public static final String HOUR_1_CACHE_NULL = "HOUR_1_CACHE_NULL";
    public static final String HOUR_12_CACHE_NULL = "HOUR_12_CACHE_NULL";

    public static final String DAY_1_CACHE_NULL = "DAY_1_CACHE_NULL";
    public static final String DAY_7_CACHE_NULL = "DAY_7_CACHE_NULL";
    public static final String DAY_30_CACHE_NULL = "DAY_30_CACHE_NULL";

    public static final String FOREVER_CACHE_NULL = "FOREVER_CACHE_NULL";

    public static List<CacheDurationConfig> cacheConfigs() {
        List<CacheDurationConfig> CacheDurationConfigs = new ArrayList<>();

        CacheDurationConfigs.add(new CacheDurationConfig(MINUTE_30, 30, TimeUnit.MINUTES, false));
        CacheDurationConfigs.add(new CacheDurationConfig(HOUR_1, 1, TimeUnit.HOURS, false));
        CacheDurationConfigs.add(new CacheDurationConfig(HOUR_12, 12, TimeUnit.HOURS, false));
        CacheDurationConfigs.add(new CacheDurationConfig(DAY_1, 1, TimeUnit.DAYS, false));
        CacheDurationConfigs.add(new CacheDurationConfig(DAY_7, 7, TimeUnit.DAYS, false));
        CacheDurationConfigs.add(new CacheDurationConfig(DAY_30, 30, TimeUnit.DAYS, false));
        CacheDurationConfigs.add(new CacheDurationConfig(FOREVER, -1, null, false));

        CacheDurationConfigs.add(new CacheDurationConfig(MINUTE_30_CACHE_NULL, 30, TimeUnit.MINUTES, true));
        CacheDurationConfigs.add(new CacheDurationConfig(HOUR_1_CACHE_NULL, 1, TimeUnit.HOURS, true));
        CacheDurationConfigs.add(new CacheDurationConfig(HOUR_12_CACHE_NULL, 12, TimeUnit.HOURS, true));
        CacheDurationConfigs.add(new CacheDurationConfig(DAY_1_CACHE_NULL, 1, TimeUnit.DAYS, true));
        CacheDurationConfigs.add(new CacheDurationConfig(DAY_7_CACHE_NULL, 7, TimeUnit.DAYS, true));
        CacheDurationConfigs.add(new CacheDurationConfig(DAY_30_CACHE_NULL, 30, TimeUnit.DAYS, true));
        CacheDurationConfigs.add(new CacheDurationConfig(FOREVER_CACHE_NULL, -1, null, true));
        return CacheDurationConfigs;
    }

    private String name;
    private long expire;
    private TimeUnit timeUnit;
    private int syncRetry = 5;
    private long syncExpire = 5000;
    private long syncSleep = 100;
    private boolean cacheNull = false;
    private boolean enhanceEnable = true;

    public CacheDurationConfig(String name, long expire, TimeUnit timeUnit, boolean cacheNull) {
        this.name = name;
        this.expire = expire;
        this.timeUnit = timeUnit;
        this.cacheNull = cacheNull;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getExpire() {
        return expire;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public int getSyncRetry() {
        return syncRetry;
    }

    public void setSyncRetry(int syncRetry) {
        this.syncRetry = syncRetry;
    }

    public long getSyncExpire() {
        return syncExpire;
    }

    public void setSyncExpire(long syncExpire) {
        this.syncExpire = syncExpire;
    }

    public long getSyncSleep() {
        return syncSleep;
    }

    public void setSyncSleep(long syncSleep) {
        this.syncSleep = syncSleep;
    }

    public boolean isCacheNull() {
        return cacheNull;
    }

    public void setCacheNull(boolean cacheNull) {
        this.cacheNull = cacheNull;
    }

    public boolean isEnhanceEnable() {
        return enhanceEnable;
    }

    public void setEnhanceEnable(boolean enhanceEnable) {
        this.enhanceEnable = enhanceEnable;
    }

}
