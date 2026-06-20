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

        // System.out.println(minHeap.peek());// topmost
        // System.out.println(minHeap.poll()); // remove topmost and returen it
        // System.out.println(minHeap.size());
        // System.out.println(minHeap.toString());
        // System.out.println(minHeap.contains(5)); // boolean

        // max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        maxHeap.offer(10);
        maxHeap.offer(5);
        maxHeap.offer(20);

        // System.out.println(maxHeap.peek()); // 20
        // System.out.println(maxHeap.poll()); // 20
        // System.out.println(maxHeap.toString()); // 20

        // --- Min Heap Tree Printer Demo ---
        int[] values = { 17, 12, 10, 2, 7, 2, 11, 20, 8 };
        PriorityQueue<Integer> heap = buildMinHeap(values);
        System.out.println("\nMax Heap Tree:");
        printHeapTree(heap);
    }

    // Builds a min heap from an array of values
    public static PriorityQueue<Integer> buildMinHeap(int[] values) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> (b - a));
        for (int v : values) {
            minHeap.offer(v);
        }
        return minHeap;
    }

    // Prints the heap as a sideways tree in the terminal.
    // PriorityQueue's toArray() returns its internal heap array, so indices map
    // correctly.
    public static void printHeapTree(PriorityQueue<?> heap) {
        if (heap == null || heap.isEmpty()) {
            System.out.println("(empty heap)");
            return;
        }
        Object[] arr = heap.toArray();
        printHeapNode(arr, 0, "", true);
    }

    private static void printHeapNode(Object[] arr, int index, String prefix, boolean isLeft) {
        if (index >= arr.length) {
            return;
        }
        // Traverse right child first (printed at top)
        printHeapNode(arr, 2 * index + 2, prefix + (isLeft ? "│   " : "    "), false);
        // Print current node
        System.out.println(prefix + (index == 0 ? "" : (isLeft ? "└── " : "┌── ")) + arr[index]);
        // Traverse left child (printed at bottom)
        printHeapNode(arr, 2 * index + 1, prefix + (isLeft ? "    " : "│   "), true);
    }
}
