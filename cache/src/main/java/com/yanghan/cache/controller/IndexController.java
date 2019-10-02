package com.yanghan.cache.controller;

import com.yanghan.cache.model.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanghan on 2019-09-28.
 */
@RestController
@RequestMapping("/user")
public class IndexController {

    @GetMapping("/get")
    @Cacheable(cacheNames = "User", key = "#user.name", condition = "#user.name != null", unless = "#result == null")
    public User get(User user) {
        System.out.println("从数据库查询");
        return user;
    }

    @GetMapping("/add")
    @CachePut(cacheNames = "User", key = "#user.name")
    public User insert(User user) {
        return user;
    }

    @GetMapping("/delete/{name}")
    @CacheEvict(cacheNames = "User", key = "#name")
    public String delete(@PathVariable String name) {
        return "OK";
    }
}
