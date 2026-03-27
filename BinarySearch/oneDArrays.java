package BinarySearch;

import java.util.Arrays;

public class oneDArrays {

    public int findPeakElement(int[] nums) {
        // leetcode-162
        // Linear search

        // for (int i = 0; i < nums.length; i++) {

        // boolean left = (i == 0) || nums[i] > nums[i - 1];
        // boolean right = (i == nums.length - 1) || nums[i] > nums[i + 1];

        // if (left && right) {
        // return i;
        // }
        // }
        // return -1;

        // binary search

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        return left;

    }

    private int picked = 6; // simulate the picked number

    private int guess(int num) {
        if (num == picked)
            return 0;
        return num > picked ? -1 : 1;
    }

    public int guessNumber(int n) {

        // leetcode-374. Guess Number Higher or Lower
        /*leetcode75-Binary Search-1*/
        int left = 0;
        int right = n;
        while (left <= right) {
            int middle = left + (right - left) / 2;

            int result = guess(middle);
            if (result == 0) {
                return middle;
            } else if (result == -1) {
                right = middle - 1; // middle is too high
            } else {
                left = middle + 1; // middle is two low
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        oneDArrays obj = new oneDArrays();
        int[] nums = new int[] { 1, 2, 1, 3, 5, 6, 4 };

        System.out.println("The peak element index in array " + Arrays.toString(nums) + " is: "
                + nums[obj.findPeakElement(nums)] + " at index " + obj.findPeakElement(nums));
        System.out.println("Guess number (picked=6, n=10): " + obj.guessNumber(10));

    }
}