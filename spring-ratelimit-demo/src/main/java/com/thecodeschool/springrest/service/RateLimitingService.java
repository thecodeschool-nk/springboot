package com.thecodeschool.springrest.service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RateLimitingService {

    private final StringRedisTemplate redisTemplate;

    public RateLimitingService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public boolean isAllowed(String key, int limit, int windowInSeconds) {
        String redisKey = "rate_limit:" + key;

        // Increment the counter
        Long currentCount = redisTemplate.opsForValue().increment(redisKey);

        // If it's the first request, set the expiration time
        if (currentCount == 1) {
            redisTemplate.expire(redisKey, Duration.ofSeconds(windowInSeconds));
        }

        // Check if the current count exceeds the limit
        return currentCount <= limit;
    }
}
