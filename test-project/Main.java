import src.ErrorPrecedence;
import src.ErrorPrecedenceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ErrorPrecedence errorPrecedence = new ErrorPrecedenceImpl();

        String response = errorPrecedence.highestPriorityException(List.of("ERR11", "ERR4", "ERR3"));
        System.out.println(response);
    }
}
