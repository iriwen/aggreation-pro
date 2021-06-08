package com.java.code.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * created by iriwen on 2020/06/15.
 */
public class LinkedHashLRUCache<K, V> implements LRUCache<K, V> {

    private final int limit;
    private final InnterLRUCache<K,V>  cache ;

    public LinkedHashLRUCache(int limit) {
        this.limit = limit;
        this.cache = new InnterLRUCache(limit);
    }

    public static void main(String[] args) {
        LinkedHashLRUCache cache = new LinkedHashLRUCache(3);
        cache.put(1,"a");
        cache.put(2,"b");
        cache.put(3,"c");
        System.out.println(cache);
        cache.put(4, "d");
        System.out.println(cache);
    }

    @Override
    public void put(K key, V value) {
        this.cache.put(key, value);
    }

    @Override
    public V get(K key) {
        return this.cache.get(key);
    }

    @Override
    public void remove(K key) {
        this.cache.remove(key);
    }

    @Override
    public int size() {
        return this.cache.internalLimit;
    }

    @Override
    public void clear() {
        this.cache.clear();
    }

    @Override
    public int limit() {
        return this.limit;
    }

    @Override
    public String toString() {
       return  this.cache.toString();
    }

    private static class InnterLRUCache<K, V> extends LinkedHashMap<K,V> {

        final int internalLimit;

        public InnterLRUCache(int internalLimit) {
            super(16, 0.75f, true);
            this.internalLimit = internalLimit;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > internalLimit;
        }
    }
}
