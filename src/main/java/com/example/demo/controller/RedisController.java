package com.example.demo.controller;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: test0.java
 * @description: 测试redis
 * @author: NiuYiq
 * @create: 2021-03-16 13:35
 **/

@RestController
public class RedisController {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/redis/{key}/{value}")
    private Boolean setValue(@PathVariable("key") String key, @PathVariable("value") String value){
        boolean flag = true;
        try {
            stringRedisTemplate.opsForValue().set(key,value);
        }catch (Exception e){
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    @GetMapping("/redis/{key}")
    private String getValue(@PathVariable("key") String key){
        return stringRedisTemplate.opsForValue().get(key);
    }
}

