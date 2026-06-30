package SlidingWindow;

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        // leetcode-930 Binary substring with sum
        int ans = slidingWindowAtMost(nums, goal) - slidingWindowAtMost(nums, goal - 1);
        return ans;
    }

    private int slidingWindowAtMost(int[] nums, int goal) {
        int start = 0;
        int currentSum = 0;
        int totalCount = 0;

        for (int end = 0; end < nums.length; end++) {
            currentSum += nums[end];

            while (start <= end && currentSum > goal) {
                currentSum -= nums[start++];
            }
            totalCount += end - start + 1;
        }
        return totalCount;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        // leetcode-1248 count the number of nice subarrays
        // int output = 0; ----------------> brute force
        // for (int i = 0; i < nums.length; i++) {
        // int count=0;
        // for (int j = i; j < nums.length; j++) {
        // if(nums[j] %2 != 0) count ++ ;

        // if(count==k){
        // output +=1 ;

        // }
        // if(count>k) break;
        // }
        // }
        // return output;

        // sliding window
        int[] newnums = new int[nums.length];
        for (int i = 0; i < newnums.length; i++) {
            if (nums[i] % 2 == 0) {
                newnums[i] = 0;
            } else {
                newnums[i] = 1;
            }
        }

        int left = 0;
        int sum = 0;
        int count = 0;
        int prefixZeros = 0;
        for (int right = 0; right < newnums.length; right++) {
            sum += newnums[right];

            while (sum > k) {
                sum -= newnums[left];
                left++;
                prefixZeros = 0;
            }
            if (sum == k) {
                while (left < newnums.length && newnums[left] == 0) {
                    prefixZeros++;
                    left++;
                }
                count += (prefixZeros + 1);
            }

        }
        return count;
    }

    // =========================================================
    // EASY SLIDING WINDOW PROBLEMS — Try solving these yourself
    // =========================================================

    // ------- ARRAY PROBLEMS -------

    /**
     * leetcode-643 | Maximum Average Subarray I
     * Given an integer array nums and an integer k, find the contiguous subarray
     * of length k that has the maximum average value and return that value.
     *
     * Example: nums = [1,12,-5,-6,50,3], k = 4 → 12.75
     */
    public double findMaxAverage(int[] nums, int k) {
        // TODO: Use a fixed-size sliding window of length k


        int left = 0 ;
        int right = 0;
        int sum = 0;


        while(right<k){
            sum += nums[right];
            right ++;
        }

        int maxsum = sum;


        while(right<nums.length){
            sum += nums[right];
            sum  -= nums[left];

            left++;
            right++;

            maxsum = Math.max(sum, maxsum);
        }
        return (double) maxsum/k; 
    }

    /**
     * leetcode-1343 | Number of Sub-arrays of Size K and Average >= Threshold
     * Given an array of integers arr, return the number of subarrays of size k
     * whose average is greater than or equal to threshold.
     *
     * Example: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4 → 3
     */
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        // TODO: Slide a fixed window of size k, check if sum >= k * threshold

        int left=0;
        int right = 0;
        int sum = 0;
        int qualified = 0;

        while (right<k) {
            sum += arr[right];
            right++;
        }

        if(sum>= k*threshold) qualified++;
        
        
        while(right<arr.length){

            
            sum += arr[right];
            sum -= arr[left];

            if(sum>= k*threshold) qualified++;
            left++;
            right++;


        }
        return qualified;
    }

    /**
     * leetcode-209 | Minimum Size Subarray Sum
     * Given an array of positive integers nums and a positive integer target,
     * return the minimal length of a subarray whose sum >= target.
     * Return 0 if no such subarray exists.
     *
     * Example: target = 7, nums = [2,3,1,2,4,3] → 2 (subarray [4,3])
     */
    public int minSubArrayLen(int target, int[] nums) {
        // TODO: Use a variable-size sliding window; shrink from left when sum >= target

        int window = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        int right ;

       for(right = 0;right<nums.length;right++){
         sum += nums[right];

         while (sum>= target) {
            window = Math.min(window, right-left+1);

            sum -= nums[left];
            left++;
            
         }
       }

       return window == Integer.MAX_VALUE? 0: window;
    }

    // ------- STRING PROBLEMS -------

    /**
     * LC-1876 | Substrings of Size Three with Distinct Characters
     * Given a string s, return the number of good substrings of length 3.
     * A substring is "good" if all 3 characters are distinct.
     *
     * Example: s = "xyzzaz" → 1 (only "xyz" has all distinct chars)
     */
    public int countGoodSubstrings(String s) {
        // TODO: Slide a fixed window of size 3, check if all chars are unique
        return 0;
    }

    /**
     * LC-1004 | Max Consecutive Ones III (Easy-ish variable window)
     * Given a binary array nums and an integer k, return the maximum number of
     * consecutive 1s if you can flip at most k 0s.
     *
     * Example: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2 → 6
     */
    public int longestOnes(int[] nums, int k) {
        // TODO: Expand right always; shrink left when zero-count exceeds k
        return 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1: [1,0,1,0,1], goal = 2 → expected 4
        int[] nums1 = { 1, 0, 1, 0, 1 };
        System.out.println("Test 1: " + sol.numSubarraysWithSum(nums1, 2)); // 4

        // Test 2: [0,0,0,0,0], goal = 0 → expected 15
        int[] nums2 = { 0, 0, 0, 0, 0 };
        System.out.println("Test 2: " + sol.numSubarraysWithSum(nums2, 0)); // 15

        // Test 3: [1,1,1], goal = 2 → expected 2
        int[] nums3 = { 1, 1, 1 };
        System.out.println("Test 3: " + sol.numSubarraysWithSum(nums3, 2)); // 2
    }
}