package SlidingWindow;

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        //leetcode-930 Binary substring with sum 
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
        //leetcode-1248 count the number of nice subarrays 
        // int output = 0; ----------------> brute force 
        // for (int i = 0; i < nums.length; i++) {
        //     int count=0;
        //     for (int j = i; j < nums.length; j++) {
        //         if(nums[j] %2 != 0) count ++ ;
                
        //         if(count==k){
        //             output +=1 ;
                    
        //         }
        //         if(count>k) break;
        //     }
        // }
        // return output;

        //sliding window 
        int[] newnums = new int[nums.length];
        for (int i = 0; i < newnums.length; i++) {
            if(nums[i] %2 ==0){
                newnums[i] = 0;
            }else{
                newnums[i]=1;
            }
        }

        int left =0;
        int sum=0;
        int count=0;
        int prefixZeros = 0;
        for(int right =0;right<newnums.length;right++){
            sum += newnums[right];

            while(sum > k){
                sum -= newnums[left];
                left++;
                prefixZeros =0;
            }
            if (sum==k) {
                while (left<newnums.length && newnums[left]==0) {
                    prefixZeros++;
                    left++;
                }
                count += (prefixZeros+1);
            }

        }
        return count;
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