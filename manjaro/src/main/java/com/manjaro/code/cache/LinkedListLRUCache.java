package com.manjaro.code.cache;

/**
 * created by iriwen on 2020/06/15.
 * 双向链表 + hashmap 实现LRU  cache
 */
public class LinkedListLRUCache<K,V> implements LRUCache<K,V>{

    private final int limit;

    public LinkedListLRUCache(int limit) {

        this.limit = limit;
    }

    @Override
    public void put(K key, V value) {

    }

    @Override
    public Object get(K key) {
        return null;
    }

    @Override
    public void remove(K key) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public int limit() {
        return 0;
    }
}
