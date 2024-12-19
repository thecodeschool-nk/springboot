package com.thecodeschool.springrest.controller;

import com.thecodeschool.springrest.service.RateLimitingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitingController {

    private final RateLimitingService rateLimitingService;

    public RateLimitingController(RateLimitingService rateLimitingService) {
        this.rateLimitingService = rateLimitingService;
    }

    @GetMapping("/api/resource")
    public String accessResource(@RequestParam String userId) {
        int limit = 5; // Max requests allowed
        int window = 60; // Time window in seconds

        if (rateLimitingService.isAllowed(userId, limit, window)) {
            return "Access granted!";
        } else {
            return "Rate limit exceeded. Try again later.";
        }
    }
}