package BinarySearch;

import java.util.Arrays;

public class oneDArrays {

    public int findPeakElement(int[] nums) {
        //leetcode-162
        // Linear search

        // for (int i = 0; i < nums.length; i++) {

        //     boolean left = (i == 0) || nums[i] > nums[i - 1];
        //     boolean right = (i == nums.length - 1) || nums[i] > nums[i + 1];

        //     if (left && right) {
        //         return i;
        //     }
        // }
        // return -1; 

        // binary search 

        int left = 0 ;
        int right = nums.length-1;
        while (left<right) {
            int mid = (left+right)/2;

            if(nums[mid]>nums[mid+1]){
                right =mid;
            }
            else{
                left = mid+1;
            }
            
        }
        return left;

    }

    public static void main(String[] args) {
        oneDArrays obj = new oneDArrays();
        int[] nums = new int[]{1, 2, 1, 3, 5, 6, 4};

        System.out.println("The peak element index in array " + Arrays.toString(nums) + " is: " + nums[obj.findPeakElement(nums)] + " at index " + obj.findPeakElement(nums));

    }
}