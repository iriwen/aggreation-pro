package com.java.code.cache;

/**
 * created by yuxiaodong01 on 2020/06/15.
 */
public interface LRUCache<K,V> {

    void put(K key, V value);

    Object get(K key);

    void remove(K key);

    int size();

    void clear();

    int limit();
}
