package Array;

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
        /*int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;*/


        // Since the Is sorted in a non decreasing order Then we need to flatten the matrix And apply the binary search if the thing or the target is found then we return positive;

        // matrix[row][column] = number 
        
    }

}