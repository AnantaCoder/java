package Extras;

import java.util.*;

public class EasyProblems {

    // 1. Stock Buy and Sell - One Transaction
    public static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }

        return maxProfit;
    }

    // 2. Count Distinct Subsequences
    public  static HashSet<String> set = new HashSet<>();

    public static void generate(String s, int index, String curr) {

        if (index == s.length()) {
            set.add(curr);
            return;
        }

        // Take character
        generate(s, index + 1, curr + s.charAt(index));

        // Don't take character
        generate(s, index + 1, curr);
    }

    public static int countDistinctSubsequences(String s) {

        set.clear();
        generate(s, 0, "");

        return set.size();
    }


    // 3. Jump Game 2 - Minimum Jumps
    public static int minJumps(int[] nums) {

        if (nums.length <= 1)
            return 0;

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }

    // 4. Count Sundays
    public static int countSundays(String startDay, int n) {

        String[] days = {
                "sun", "mon", "tue", "wed",
                "thu", "fri", "sat"
        };

        int startIndex = 0;

        for (int i = 0; i < 7; i++) {
            if (days[i].equals(startDay)) {
                startIndex = i;
                break;
            }
        }

        int firstSunday;

        if (startIndex == 0)
            firstSunday = 0;
        else
            firstSunday = 7 - startIndex;

        if (firstSunday >= n)
            return 0;

        return ((n - firstSunday - 1) / 7) + 1;
    }

    // 5. Maximum Consecutive 1s or 0s
    public static int maxConsecutive(int[] arr) {

        int maxLen = 1;
        int current = 1;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] == arr[i - 1]) {
                current++;
            } else {
                current = 1;
            }

            maxLen = Math.max(maxLen, current);
        }

        return maxLen;
    }

    // 6. Stickler Thief
    public static int sticklerThief(int[] arr) {

        if (arr.length == 0)
            return 0;

        if (arr.length == 1)
            return arr[0];

        int prev2 = arr[0];
        int prev1 = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {

            int take = arr[i] + prev2;
            int notTake = prev1;

            int current = Math.max(take, notTake);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {

        int[] prices = {7, 10, 1, 3, 6, 9, 2};
        System.out.println("Stock Profit = " + maxProfit(prices));

        System.out.println("Distinct Subsequences = "
                + countDistinctSubsequences("gfg"));

        int[] jumpsArr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println("Minimum Jumps = " + minJumps(jumpsArr));

        System.out.println("Sundays = " + countSundays("mon", 13));

        int[] binary = {0, 1, 0, 1, 1, 1, 1};
        System.out.println("Max Consecutive = " + maxConsecutive(binary));

        int[] houses = {6, 7, 1, 3, 8, 2, 4};
        System.out.println("Stickler Thief = " + sticklerThief(houses));
    }
}
