package Hash;

import java.util.HashMap;

public class HashMedium {
    public int equalPairs(int[][] grid) {
        // leetcode-2353 Equal row and column pairs
        /* leetcode75-hashing-4 */

        // brute force
        // int rowL = grid.length;
        // int colL = grid[0].length;
        // int equal = 0;

        // for (int i = 0; i < rowL; i++) {
        // for (int j = 0; j < colL; j++) {

        // boolean isEqual = true;

        // // compare row i with column j
        // for (int k = 0; k < colL; k++) {
        // if (grid[i][k] != grid[k][j]) {
        // isEqual = false;
        // break;
        // }
        // }
        // if (isEqual) {
        // equal++;
        // }
        // }
        // }
        // return equal;

        // optimal hashing hashmap function

        int len = grid.length;
        int equal = 0;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            String row = "";
            for (int j = 0; j <len; j++) {
                row += grid[i][j]+",";
            }
            map.put(row,map.getOrDefault(row,0)+1);
        }
        for (int i = 0; i < len; i++) {
            String col = "";
            for (int j = 0; j <len; j++) {
                col += grid[j][i]+",";
            }
            if (map.containsKey(col)) {
                equal += map.get(col);
            }
        }
        System.out.println(map);



        return equal;
    }

    public static void main(String[] args) {
        HashMedium obj = new HashMedium();

        // grid1: expected output = 1
        int[][] grid1 = {
                { 3, 2, 1 },
                { 1, 7, 6 },
                { 2, 7, 7 }
        };
        System.out.println("grid1 equalPairs: " + obj.equalPairs(grid1)); // 1

        // grid2: expected output = 3
        int[][] grid2 = {
                { 3, 1, 2, 2 },
                { 1, 4, 4, 5 },
                { 2, 4, 2, 2 },
                { 2, 4, 2, 2 }
        };
        System.out.println("grid2 equalPairs: " + obj.equalPairs(grid2)); // 3
    }
}
