package com.thecodeschool.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @PostMapping("/addKey")
    public String addKey(@RequestParam String key, @RequestParam String value) {
        redisTemplate.opsForValue().set(key, value);
        return String.format("Key %s added to Redis", key);
    }

    @GetMapping("/getKey")
    public String getKey(@RequestParam String key) {
        String value = (String)redisTemplate.opsForValue().get(key);
        return (value == null) ? "Key not found" : value;
    }

    @DeleteMapping("/deleteKey")
    public String deleteKey(@RequestParam String key){
        return redisTemplate.delete(key) ? String.format("Key %s deleted", key) : "Key not found";
    }

    @PostMapping("/addKeyWithExpr")
    public String addKeyWithExpr(@RequestParam String key, @RequestParam String value, @RequestParam long expr) {
        redisTemplate.opsForValue().set(key, value);
        redisTemplate.expire(key, expr, TimeUnit.MILLISECONDS);
        return String.format("Key %s added to Redis with expiration of %d milliseconds", key, expr);
    }
}
