package com.cayzlh.springbootdockerdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenanyu
 * @date 2019/9/26.
 */
@RestController
public class DockerController {

    @Autowired
    @Lazy
    private StringRedisTemplate redisTemplate;

    @GetMapping("/")
    public String index() {
        redisTemplate.opsForValue().increment("request_key", 1);
        String times = redisTemplate.opsForValue().get("request_key");
        return "Hello Docker! you had request "+times+" times!!!!!!!!!";
    }

}
