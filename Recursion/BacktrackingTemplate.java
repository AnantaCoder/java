package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BacktrackingTemplate {

    // leetcode-78 Subsets

    // type one of backtracking ------------------------------------------>
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;

    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    // --------------------------------------------------------------------25 21 16
    // 16 17 14 16 14 15 14

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        // leetcode-90. Subsets II

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtractDup(result, new ArrayList<>(), 0, nums);
        return result;
    }

    private static void backtractDup(
            List<List<Integer>> result,
            List<Integer> temp,
            int start,
            int[] nums) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            backtractDup(result, temp, i + 1, nums);
            temp.remove(temp.size() - 1);
        }
    }

    // ---------------------------------------------------------------------------------------

    public int countPrime(int n) {
        List<Integer> primes = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
                if(isPrime(i)) primes.add(i);
        }

        return primes.size();
    }

    private boolean isPrime(int x) {
        // 1 and all negative numbers are not prime
        if (x <= 1)
            return false;

        // 2 and 3 are prime
        if (x <= 3)
            return true;

        // Eliminate multiples of 2 and 3 quickly
        if (x % 2 == 0 || x % 3 == 0)
            return false;

        // Check factors up to the square root, skipping multiples of 2 and 3
        // All primes greater than 3 are of the form 6k ± 1
        for (int i = 5; i * i <= x; i += 6) {
            if (x % i == 0 || x % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    public int minFlips(int a, int b, int c) {
        //leetcode-1318. Minimum Flips to Make a OR b Equal to c
        // Stores the total number of flips required
        int flips = 0;

        // Process every bit until all three numbers become 0
        while (a > 0 || b > 0 || c > 0) {

            // Extract the last (least significant) bit of each number
            // Example:
            // a = 10 (1010)
            // a & 1 = 0
            int abit = a & 1;
            int bbit = b & 1;
            int cbit = c & 1;

            // -------------------------
            // CASE 1 : c's current bit is 0
            // We need (a | b) to also be 0.
            //
            // Possible cases:
            // a b -> flips
            // 0 0 -> 0
            // 0 1 -> 1
            // 1 0 -> 1
            // 1 1 -> 2
            //
            // Since abit and bbit are only 0 or 1,
            // their sum directly equals the number of flips.
            // -------------------------
            if (cbit == 0) {
                flips += abit + bbit;
            }

            // -------------------------
            // CASE 2 : c's current bit is 1
            // We need (a | b) to be 1.
            //
            // Only one bad case:
            // a b
            // 0 0
            //
            // Flip either a or b once.
            // -------------------------
            else {
                if (abit == 0 && bbit == 0) {
                    flips++;
                }
            }

            // Remove the bit we just processed
            // Example:
            // 1010 >> 1 = 0101
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }

        return flips;
    }
}
