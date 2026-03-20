package Array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArraysHard {
    public List<List<Integer>> threeSum(int[] nums) {
        // leetcode-15 3Some Given an integer array nums, return all the triplets
        // [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i]
        // + nums[j] + nums[k] == 0.
        // Notice that the solution set must not contain duplicate triplets.

        // brute force 3 loops
        /*
         * Set<List<Integer>> set = new HashSet<>(); // set will ignore the brute force
         * approach .
         * 
         * for (int i = 0; i < nums.length; i++) {
         * for (int j = i + 1; j < nums.length; j++) {
         * for (int k = j + 1; k < nums.length; k++) {
         * 
         * if (nums[i] + nums[j] + nums[k] == 0) {
         * // store it to set
         * List<Integer> triplet = new ArrayList<>();
         * triplet.add(nums[i]);
         * triplet.add(nums[j]);
         * triplet.add(nums[k]);
         * 
         * // sort
         * Collections.sort(triplet);
         * set.add(triplet);
         * 
         * }
         * }
         * }
         * 
         * }
         * return new ArrayList<>(set);
         */

        // better
        /*
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> hashSet = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int third = -(nums[i] + nums[j]);
                if (hashSet.contains(third)) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(third);
                    Collections.sort(temp); // avoid duplicates
                    result.add(temp);
                }
                hashSet.add(nums[j]);
            }
        }
        return new ArrayList<>(result);
        */
    
        // optimal 

        
    
    
    }


    public static void main(String[] args) {
        ArraysHard obj = new ArraysHard();
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> result = obj.threeSum(nums);
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}
