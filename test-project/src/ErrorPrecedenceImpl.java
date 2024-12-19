package src;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class ErrorPrecedenceImpl implements ErrorPrecedence {

    public int lookupErrorPriority(String errorCode) {
        Integer priority = ErrorPrecedenceMap.errorCodePriorityMap.get(errorCode);

        return priority == null ? 10000 : priority;
    }

    public String highestPriorityException(List<String> errorCodes) {
        Map<String, Integer> errorCodeMap = ErrorPrecedenceMap.errorCodePriorityMap;
        AtomicInteger basePriority = new AtomicInteger();
        basePriority.set(99999);

        AtomicReference<String> responseErrorCode = new AtomicReference<>();

        // get all the priorities
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
