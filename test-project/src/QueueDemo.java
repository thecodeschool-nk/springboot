package src;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList();
        queue.offer(1);
        queue.offer(1);
        queue.offer(0);
        queue.offer(0);

        queue.stream().forEach(System.out::println);
        System.out.println(queue);
    }
}
