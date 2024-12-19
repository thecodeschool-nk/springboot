package src;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(1);
        stack.push(0);
        stack.push(1);

        stack.stream().forEach(System.out::println);

        System.out.println(stack);
    }
}
