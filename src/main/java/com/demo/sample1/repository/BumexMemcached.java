package com.demo.sample1.repository;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class BumexMemcached {
    private ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();

    public void set(String key, Object value) {
        map.put(key, value);
    }

    public Object get(String key) {
        return map.get(key);
    }

    public void delete(String key) {
        map.remove(key);
    }
}
