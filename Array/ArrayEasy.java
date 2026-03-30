package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayEasy {
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        // leetcode-88 merge sorted arrays .
        /*
         * You are given two integer arrays nums1 and nums2, sorted in non-decreasing
         * order, and two integers m and n, representing the number of elements in nums1
         * and nums2 respectively.
         * 
         * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
         * 
         * The final sorted array should not be returned by the function, but instead be
         * stored inside the array nums1. To accommodate this, nums1 has a length of m +
         * n, where the first m elements denote the elements that should be merged, and
         * the last n elements are set to 0 and should be ignored. nums2 has a length of
         * n.
         * 
         * 
         * 
         * Example 1:
         * 
         * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
         * Output: [1,2,2,3,5,6]
         * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
         * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming
         * from nums1.
         * Example 2:
         * 
         * Input: nums1 = [1], m = 1, nums2 = [], n = 0
         * Output: [1]
         * Explanation: The arrays we are merging are [1] and [].
         * The result of the merge is [1].
         * Example 3:
         * 
         * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
         * Output: [1]
         * Explanation: The arrays we are merging are [] and [1].
         * The result of the merge is [1].
         * Note that because m = 0, there are no elements in nums1. The 0 is only there
         * to ensure the merge result can fit in nums1.
         */

        int[] temp = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m) {
            temp[k] = nums1[i];
            i++;
            k++;
        }

        while (j < n) {
            temp[k] = nums2[j];
            j++;
            k++;
        }

        for (int a = 0; a < temp.length - 1; a++) {
            for (int b = 0; b < temp.length - a - 1; b++) {
                if (temp[b] > temp[b + 1]) {
                    int swap = temp[b];
                    temp[b] = temp[b + 1];
                    temp[b + 1] = swap;
                }
            }
        }

        return temp;
    }

    public boolean canThreePartsEqualSum(int[] arr) {
        // so the intuition is to get the total sum --> devide it by 3 -->
        int totalSum = 0;
        int currentSum = 0;
        int partsFound = 0;

        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }
        if (totalSum % 3 != 0)
            return false;

        int idealPartsFound = totalSum / 3;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum == idealPartsFound) {
                partsFound++;
                currentSum = 0;
            }
        }
        return (partsFound >= 3);
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // leetcode-1431. Kids With the Greatest Number of
        /* leetcode75-3 */
        int n = candies.length;
        List<Boolean> candiesList = new ArrayList<>();
        int maxCadies = maxNumberofCandies(candies);
        for (int i = 0; i < n; i++) {
            if (candies[i] + extraCandies >= maxCadies) {
                candiesList.add(true);
            } else {
                candiesList.add(false);
            }
        }
        return candiesList;
    }

    private int maxNumberofCandies(int[] candies) {
        int max = candies[0];
        for (int candy : candies) {
            if (candy > max)
                max = candy;
        }
        return max;
    }

    public double findMaxAverage(int[] nums, int k) {

        // leetcode-643 maximum avarage subarray
        /*leetcode75-slidingWindow-1 */
        int windowsum = 0;
        for (int i = 0; i < k; i++) {
            windowsum += nums[i];
        }

        int maxSum = windowsum;

        for (int i = k; i < nums.length; i++) {
            windowsum += nums[i];
            windowsum -= nums[i - k];
            if (windowsum > maxSum) {
                maxSum = windowsum;
            }
        }

        return (double) maxSum / k;
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // leetcode-605 Can place flowers positioning n alternate position 010 like this
        // ...
        /* leetcode75-4 */
        /*
         * check left and right
         * if empty place them and then place the flower n -=1
         */
        int len = flowerbed.length;

        for (int i = 0; i < len; i++) {

            boolean leftEmpty = false;
            boolean rightEmpty = false;

            if (flowerbed[i] == 0) {
                // i=0 , i=2|| i=
                if (i == 0 || flowerbed[i - 1] == 0)
                    leftEmpty = true;
                if (i == len - 1 || flowerbed[i + 1] == 0)
                    rightEmpty = true;

                if (leftEmpty == true && rightEmpty == true) {
                    n -= 1;
                    flowerbed[i] = 1; // ful futeche
                    i += 1;
                }
            }
        }
        return (n <= 0);

    }

    public static void main(String[] args) {
        ArrayEasy obj = new ArrayEasy();
        int[] arr = new int[] { 0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1 };
        int[] flowerBed = new int[] { 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 };
        boolean result = obj.canThreePartsEqualSum(arr);
        boolean canPlant = obj.canPlaceFlowers(flowerBed, 6);
        System.out.println(canPlant);
    }
}
