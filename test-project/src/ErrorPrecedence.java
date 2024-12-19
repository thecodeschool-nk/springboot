package src;

import java.util.List;

public interface ErrorPrecedence {

    public int lookupErrorPriority(String errorCode);

    public String highestPriorityException(List<String> errorCodeList);
}
