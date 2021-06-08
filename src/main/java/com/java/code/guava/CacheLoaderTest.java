package com.java.code.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.java.code.entity.Employee;

import java.util.concurrent.TimeUnit;

/**
 * created by iriwen on 2020/06/05.
 */
public class CacheLoaderTest {

    public static void main(String[] args) throws Exception {
        LoadingCache<String, Employee> cache = CacheBuilder.newBuilder()
                .maximumSize(10).expireAfterAccess(3, TimeUnit.SECONDS)
                .build(new CacheLoader<String, Employee>() {
                    @Override
                    public Employee load(String key) throws Exception {
                         return find(key);
                    }
                });

        Employee dss = cache.get("dss");
        Thread.sleep(10000000);
    }

    public static Employee find(final String id){

        System.out.println("the emplpyer " + id + "is loading  from DB");

        return new Employee(id, "iriwen", "dev");
    }

}
