package com.thecodeschool.springrest.service;

import com.thecodeschool.springrest.config.CustomProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class ErrorCodeService {

    private final CustomProperties customProperties;

    @Autowired
    public ErrorCodeService(CustomProperties customProperties) {
        this.customProperties = customProperties;
    }

    public int lookupErrorPriority(String errorCode) {
        Integer priority = customProperties.getErrorCodeConfiguration().get(errorCode);

        return priority == null ? 10000 : priority;
    }

    public String highestPriorityErrorCode(List<String> errorCodes) {
        AtomicInteger basePriority = new AtomicInteger();
        basePriority.set(99999);
        AtomicReference<String> responseErrorCode = new AtomicReference<>();

        errorCodes.stream()
                .forEach(errorCode -> {
                    if (lookupErrorPriority(errorCode) < basePriority.get()) {
                        responseErrorCode.set(errorCode);
                        basePriority.set(lookupErrorPriority(errorCode));
                    }
                });

        return responseErrorCode.get();
    }
}
