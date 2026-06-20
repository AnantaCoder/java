package Heap;

import java.util.PriorityQueue;

public class HeapBasics {

    public static void main(String[] args) {
        /*
         * offer() -> O(log n)
         * poll() -> O(log n)
         * peek() -> O(1)
         * size() -> O(1)
         * isEmpty() -> O(1)
         * contains() -> O(n)
         * remove(x) -> O(n)
         * pq.offer(x); // Insert
         * pq.peek(); // Top element
         * pq.poll(); // Remove top
         */

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // min heap
        minHeap.offer(10);
        minHeap.offer(5);
        minHeap.offer(20);

        System.out.println(minHeap.peek());// topmost
        System.out.println(minHeap.poll()); // remove topmost and returen it
        System.out.println(minHeap.size());
        System.out.println(minHeap.toString());
        System.out.println(minHeap.contains(5)); // boolean

        // max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        maxHeap.offer(10);
        maxHeap.offer(5);
        maxHeap.offer(20);

        System.out.println(maxHeap.peek()); // 20
        System.out.println(maxHeap.poll()); // 20
        System.out.println(maxHeap.toString()); // 20
    }

}
