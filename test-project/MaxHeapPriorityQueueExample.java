import java.util.PriorityQueue;
import java.util.Comparator;

class Task implements Comparable<Task> {
    String name;
    int priority;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);  // For min-heap
    }

    @Override
    public String toString() {
        return name + " (Priority: " + priority + ")";
    }
}

public class MaxHeapPriorityQueueExample {
    public static void main(String[] args) {
        // Create a max-heap by using a custom comparator that orders in descending order
        PriorityQueue<Task> pq = new PriorityQueue<>(Comparator.reverseOrder());

        // Add tasks with different priorities
        pq.add(new Task("Task 1", 3));
        pq.add(new Task("Task 2", 1));  // Priority 1 (highest priority)
        pq.add(new Task("Task 3", 2));  // Priority 2

        // Peek at the task with the highest priority (max-heap: largest priority)
        System.out.println("Peek: " + pq.peek());  // Expected output: Task 1 (Priority: 3)

        // Remove and process tasks in order of priority (max-heap: largest priority first)
        while (!pq.isEmpty()) {
            Task task = pq.poll();  // Removes the task with the highest priority
            System.out.println("Processing: " + task);
        }
    }
}
