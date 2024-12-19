package com.thecodeschool.springrest.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Configuration
@ConfigurationProperties(prefix = "custom")
public class CustomProperties {
    
    private Map<String, Integer> errorCodeConfiguration;

    public Map<String, Integer> getErrorCodeConfiguration() {
        return errorCodeConfiguration;
    }

    public void setErrorCodeConfiguration(Map<String, Integer> errorCodeConfiguration) {
        this.errorCodeConfiguration = errorCodeConfiguration;
    }
}