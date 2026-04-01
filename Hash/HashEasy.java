package Hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class HashEasy {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // Leetcode-2215 find the differance of two arrays
        /* leetcode75-hashing-1 */
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }

        // finding differance
        List<Integer> dif1 = new ArrayList<>();
        List<Integer> dif2 = new ArrayList<>();

        for (int n : set1) {
            if (!set2.contains(n)) {
                dif1.add(n);
            }
        }
        for (int n : set2) {
            if (!set1.contains(n)) {
                dif2.add(n);
            }
        }

        // combing them
        List<List<Integer>> result = new ArrayList<>();
        result.add(dif1);
        result.add(dif2);

        return result;
    }

    public static boolean uniqueOccurrences(int[] arr) {
        // leetcode-1207 Unique number of Occurances
        /* leetcode75-hashing-2 */

        // hashmap for count the frequency and hashset fr the uniqeness
        // hashmap store number with the frequency but the hashset is for unique bitches
        // put the number of ints has unique occuranmcesa found in the hashset then it
        // will retuern false
        HashMap<Integer, Integer> hmap = new HashMap<>();
        HashSet<Integer> hset = new HashSet<>();
        for (int num : arr) {
            hmap.put(num, hmap.getOrDefault(num, 0) + 1);
        }
        System.out.println("Hashmap is " + hmap);

        for (int numberOfOccurances : hmap.values()) {
            if (hset.contains(numberOfOccurances)) {
                return false;
            }
            hset.add(numberOfOccurances);
        }
        return true;
    }

    public static boolean closeStrings(String word1, String word2) {
        // leetcode-1657. Determine if Two Strings Are Close
        /* leetcode75-hashing-3 */

        // intuition is to store the frequency of the charecters in the string using the
        // hashmap since order does not matter.

        if (word1.length() != word2.length())
            return false;

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        for (char letter : c1) {
            map1.put(letter, map1.getOrDefault(letter, 0) + 1);
        }
        for (char letter : c2) {
            map2.put(letter, map2.getOrDefault(letter, 0) + 1);
        }
        System.out.println("The map1 is " + map1);

        // checking the key sets matches

        if (!map1.keySet().equals(map2.keySet())) {
            return false;
        }
        // checking the frequewncy distribution
        List<Integer> freq1 = new ArrayList<>(map1.values());
        List<Integer> freq2 = new ArrayList<>(map2.values());

        // this sortinmg is not optimal; it can be improved 
        Collections.sort(freq1);
        Collections.sort(freq2);

        return freq1.equals(freq2);

    }

    public static void main(String[] args) {
        HashEasy obj = new HashEasy();

        // leetcode-2215: Find the Difference of Two Arrays
        int[] nums1 = { 1, 2, 3 };
        int[] nums2 = { 2, 4, 6 };
        System.out.println("findDifference: " + obj.findDifference(nums1, nums2));

        // leetcode-1207: Unique Number of Occurrences
        int[] array = new int[] { 1, 2, 2, 1, 1, 3 };
        System.out.println("uniqueOccurrences: " + uniqueOccurrences(array));

        // leetcode-1657: Determine if Two Strings Are Close
        String word1 = "abc";
        String word2 = "bca";
        System.out.println("closeStrings(\"" + word1 + "\", \"" + word2 + "\"): " + closeStrings(word1, word2));

        String word3 = "abc";
        String word4 = "abd";
        System.out.println("closeStrings(\"" + word3 + "\", \"" + word4 + "\"): " + closeStrings(word3, word4));
    }
}