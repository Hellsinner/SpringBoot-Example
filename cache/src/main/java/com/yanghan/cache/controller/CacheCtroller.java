package com.yanghan.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanghan on 2019-09-28.
 */
@RestController
@RequestMapping("/cache")
public class CacheCtroller {

    @Autowired
    private CacheManager cacheManager;

    @GetMapping("/get/{name}/{key}")
    public Object getCache(@PathVariable String name, @PathVariable String key) {
        Cache cache = cacheManager.getCache(name);
        Cache.ValueWrapper wrapper = cache.get(key);
        return wrapper.get();
    }

    @GetMapping("/evict/{name}/{key}")
    public String evictCache(@PathVariable String name, @PathVariable String key) {
        cacheManager.getCache(name).evict(key);
        return "OK";
    }

    @GetMapping("/clear/{name}")
    public String clearCache(@PathVariable String name) {
        cacheManager.getCache(name).clear();
        return "OK";
    }

    @GetMapping("/info")
    public Object infoAll() {
        return cacheManager.getCacheNames();
    }
}
