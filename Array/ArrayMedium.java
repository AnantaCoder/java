package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayMedium {

    public int maxSumDivThree(int[] nums) {
        // leetcode-1262-Given an integer array nums, return the maximum possible sum of
        // elements of the array such that it is divisible by three.
        int sum = 0;

        int min1a = Integer.MAX_VALUE, min1b = Integer.MAX_VALUE;
        int min2a = Integer.MAX_VALUE, min2b = Integer.MAX_VALUE;

        for (int num : nums) {
            sum += num;

            if (num % 3 == 1) {
                if (num < min1a) {
                    min1b = min1a;
                    min1a = num;
                } else if (num < min1b) {
                    min1b = num;
                }
            } else if (num % 3 == 2) {
                if (num < min2a) {
                    min2b = min2a;
                    min2a = num;
                } else if (num < min2b) {
                    min2b = num;
                }
            }
        }
        if (sum % 3 == 0)
            return sum;
        if (sum % 3 == 1) {
            int option1 = (min1a == Integer.MAX_VALUE) ? 0 : sum - min1a;
            int option2 = (min2b == Integer.MAX_VALUE) ? 0 : sum - min2a - min2b;
            return Math.max(option1, option2);
        }
        if (sum % 3 == 2) {
            int option1 = (min2a == Integer.MAX_VALUE) ? 0 : sum - min2a;
            int option2 = (min1b == Integer.MAX_VALUE) ? 0 : sum - min1a - min1b;
            return Math.max(option1, option2);
        }

        return 0;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        // leetcode-74 search in 2d matrix .

        // brute force approach
        /*
         * int rows = matrix.length;
         * int cols = matrix[0].length;
         * for (int i = 0; i < rows; i++) {
         * for (int j = 0; j < cols; j++) {
         * 
         * if (matrix[i][j] == target) {
         * return true;
         * }
         * }
         * }
         * return false;
         */

        // Since the Is sorted in a non decreasing order Then we need to flatten the
        // matrix And apply the binary search if the thing or the target is found then
        // we return positive;
        // intuition Convert 2D matrix into a virtual sorted 1D array and apply binary
        // search using index mapping.

        // matrix[row][column] = number

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            int row = mid / cols;
            int col = mid % cols;
            int number = matrix[row][col];
            if (number == target) {
                return true;
            } else if (number < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;

    }

    public boolean increasingTriplet(int[] nums) {
        // leetcode-334 Increasing triplet subsequence
        /* leetcode75-8 */

        // i need to find the 1st , 2nd and 3rd largest number in array

        int n = nums.length;
        // brute force -

        // for (int i = 0; i < n; i++) {
        // for (int j = i + 1; j < n; j++) {
        // if (nums[j] > nums[i]) {
        // for (int k = j + 1; k < n; k++) {
        // if (nums[k] > nums[j]) {
        // return true;
        // }
        // }
        // }
        // }
        // }
        // return false;

        // greedy optimal approach
        // goal is if exists then we do this

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int i : nums) {
            if (i <= first) {
                first = i;
            } else if (i <= second) {
                second = i;
            } else {
                return true;
            }
        }
        return false;

    }

    public int[] productExceptSelf(int[] nums) {
        // leetcode-238 Product of Array Except Self
        /* leetcode75-6 */

        int n = nums.length;
        int[] answer = new int[n];

        // slicing and multiplication in two distinct arrays
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * right;
            right = right * nums[i];
        }

        return answer;
    }

    public int compress(char[] chars) {
        // leetcode-443 String Comparison
        /* leetcode75-9 */
        // compress by length -> a1b2c3-> return the compresses length
        int write = 0;
        int i = 0;
        while (i < chars.length) {
            char current = chars[i];
            int count = 0;

            while (i < chars.length && chars[i] == current) {
                i++;
                count++;
            }
            chars[write++] = current;

            if (count > 1) {
                String churreStr = String.valueOf(count);
                for (char c : churreStr.toCharArray()) {
                    chars[write++] = c;
                }

            }

        }
        return write;
    }

    public int maxArea(int[] height) {
        // leetcode-11 container with most water
        /* leetcode75-twoPointers-3 */

        int left = 0;
        int right = height.length - 1; // 8
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            int area = width * h;

            if (area > maxArea) {
                maxArea = area;
            }
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }

        }
        return maxArea;

    }

    public int maxOperations(int[] nums, int k) {
        // leetcode-1679. Max Number of K-Sum Pairs
        /* leetcode75- */

        // brute force approach
        // boolean[] used = new boolean[nums.length];
        // int count = 0;
        // for (int i = 0; i < nums.length; i++) {
        // if (used[i]) {
        // continue;
        // }
        // for (int j = i+1; j < nums.length; j++) {

        // if (nums[i]+nums[j]==k && !used[j]) {
        // used[i]=true;
        // used[j]=true;
        // count++;
        // break;
        // }
        // }
        // }
        // return count;

        // better two pointers
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int count = 0;

        while (left < right) {

            int sum = nums[left] + nums[right];

            if (sum == k) {
                count++;
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }

        }
        return count;

        // best hashmaps
    }

    public int longestSubarray(int[] nums) {
        // leetcode-1493 Longest subarray of 1s after deleting one element
        /* leetcode75-slidingWindow-4 */

        // so we need to fing the array with maximum number of zeros which is one
        int left = 0;
        int maxLeangth = 0;
        int maxZeros = 0;

        // window 1{}
        for (int right=0; right < nums.length; right++) {
            if (nums[right] == 0) {
                maxZeros++;
            }
            while (maxZeros>1) {
                if (nums[left]==0) {
                    maxZeros--;
                }
                left++;
            }
            int differance   = right-left;

           maxLeangth = Math.max(maxLeangth, differance);
        }
return maxLeangth;
    }

    public int longestOnes(int[] nums, int k) {
        // leetcode-1004 Max consicutive ones III */
        /* leetcode75-slidingwindow-3 */
        int start = 0;
        int zeros = 0;
        int maxLen = 0;

        for (int end = 0; end < nums.length; end++) {

            // add element
            if (nums[end] == 0)
                zeros++;

            // shrink window if invalid
            while (zeros > k) {
                if (nums[start] == 0)
                    zeros--;
                start++;
            }

            // update max
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;

    }

    public static void main(String[] args) {
        ArrayMedium obj = new ArrayMedium();
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        System.out.println(obj.searchMatrix(matrix, 3));
        System.out.println(obj.searchMatrix(matrix, 13));
        int[] nums = new int[]{0,1,1,1,0,1,1,0,1};
        char[] chars = new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        System.out.println("the length of the compresses string is " + obj.compress(chars));
        System.out.println("this string with max zeros after removikng one element is : "+obj.longestSubarray(nums));
    }

}