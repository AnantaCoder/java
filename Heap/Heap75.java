package Heap;

import java.util.PriorityQueue;

public class Heap75 {

    public static void main(String[] args) {
        int[] values = { 17, 12, 10, 2, 7, 2, 11, 20, 8 };
        long ans = totalCost(values, 3, 4);
        System.out.println("total cost of hiring is : " + ans);
    }

    public static long totalCost(int[] costs, int k, int candidates) {
        //leetcode-2462. Total Cost to Hire K Workers
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

        int left = 0;
        int right = costs.length - 1;

        for (int i = 0; i < candidates && left <= right; i++) {
            leftHeap.offer(costs[left++]);
        }
        for (int i = 0; i < candidates && left <= right; i++) {
            rightHeap.offer(costs[right--]);
        }
        HeapBasics.printHeapTree(rightHeap);
        HeapBasics.printHeapTree(rightHeap);

        long total = 0;

        while (k-- > 0) {

            int leftMin = leftHeap.isEmpty() ? Integer.MAX_VALUE : leftHeap.peek();
            int rightMin = rightHeap.isEmpty() ? Integer.MAX_VALUE : rightHeap.peek();

            if (leftMin <= rightMin) {
                total += leftHeap.poll();
                if (left <= right) {
                    leftHeap.offer(costs[left++]);
                }
            } else {
                total += rightHeap.poll();
                if (left <= right) {
                    rightHeap.offer(costs[right--]);
                }
            }

        }

        return total;
    }


    public int findKthLargest(int[] nums, int k) {
        // leetcode-215. Kth Largest Element in an Array
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->(b-a));

        for(int num: nums) heap.offer(num);
        int ans=0;
        while(k-- >0){
            ans = heap.poll();
        }

        return ans;
    }


     public int maxProduct(int[] nums) {
        //leetcode-1464. Maximum Product of Two Elements in an Array
        PriorityQueue<Integer> pq =
            new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            pq.offer(num);
        }
        int first = pq.poll();
        int second = pq.poll();
        return (first - 1) * (second - 1);
    }



}
