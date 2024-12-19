package src;

import java.util.Map;

//@Configuration
public class ErrorPrecedenceMap {

//    @Value("myapp.errorcode.map")
    public static Map<String, Integer> errorCodePriorityMap = Map.of("ERR1", 4, "ERR2", 3, "ERR3", 5,"ERR4", 2);
}
