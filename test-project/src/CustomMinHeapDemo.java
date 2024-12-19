package src;

import java.util.Comparator;
import java.util.PriorityQueue;

class CustomMinHeapDemo {
    public static void main(String[] args) {
        // Create a custom comparator to define the min-heap behavior
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());

        // Add elements to the heap
        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(15);
        minHeap.add(20);
        minHeap.add(3);

        // Print the min-heap (not in sorted order)
        System.out.println("Min-Heap: " + minHeap);

        // Remove elements
        System.out.println("Removed smallest element: " + minHeap.poll()); // Removes 3
        System.out.println("Removed smallest element: " + minHeap.poll()); // Removes 5

        // Print the updated heap
        System.out.println("Min-Heap after removals: " + minHeap);

        // Peek at the smallest element
        System.out.println("Smallest element (peek): " + minHeap.peek());  // Peeks 10
    }
}