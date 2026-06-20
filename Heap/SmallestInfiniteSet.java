package Heap;

import java.util.HashSet;
import java.util.PriorityQueue;

class SmallestInfiniteSet {
    //leetcode-2336. Smallest Number in Infinite Set

    private PriorityQueue<Integer> minheap;
    private HashSet<Integer> set;
    private int current;
    public SmallestInfiniteSet() {
        minheap = new PriorityQueue<>();
        set = new HashSet<>();
        current = 1;
    }
    
    public int popSmallest() {
        if(!minheap.isEmpty()){
            int smallest  = minheap.poll();
            set.remove(smallest);
            return smallest;
        }
        return current++;
    }
    
    public void addBack(int num) {
        if(num<current && !set.contains(num)){
            set.add(num);
            minheap.offer(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */