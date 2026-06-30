package BinarySearch;

import java.util.Arrays;

/**
 * The75
 */
public class The75 {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        //leetcode-2300. Successful Pairs of Spells and Potions

        //BRUTE FORCE------->

        //    int n  = spells.length;
        //    int m = potions.length;

        //    int[] pairs = new int[n];

        //    for(int i = 0;i<n;i++){
        //     int count = 0;
        //     for(int j=0;j<m;j++){
        //             if(spells[i]*potions[j] >= success) count++;
        //     }
        //     pairs[i]= count;
        //    }

        //    return pairs;

        // ---------------------------------------------

        int n = spells.length;
        int m = potions.length;
        int[] pairs = new int[n];

        Arrays.sort(potions);


        for (int i = 0; i < n; i++) {
        int left = 0;
        int right = m - 1;

            while (left <= right) { // searching until the search space is empty 
                int mid = left + (right - left) / 2;

                if ( (long)spells[i] * potions[mid] >= success) { // long in case of integer overflow
                    right = mid - 1;

                } else {
                    left = mid + 1;
                }
            }

            pairs[i] = m-left;
        }

        return pairs;

    }
}