package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasicRecursions {
    public List<String> letterCombinations(String digits) {

        //leetcode-17. Letter Combinations of a Phone Number
        Map<Character, String> phonebook = new HashMap<>();

        phonebook.put('2', "abc");
        phonebook.put('3', "def");
        phonebook.put('4', "ghi");
        phonebook.put('5', "jkl");
        phonebook.put('6', "mno");
        phonebook.put('7', "pqrs");
        phonebook.put('8', "tuv");
        phonebook.put('9', "wxyz");
        
        List<String> result = new ArrayList<>();

        if(digits.length()==0) return result;

        backtrackCom(digits,0,phonebook,new StringBuilder(), result);

        return result;


    }
    public void backtrackCom(
    String digits,
    int index,
    Map<Character, String> phonebook,
    StringBuilder current,
    List<String> result
    ){
      // whats the simplest possible input? current index
      // what choices do i have (visualize)
      //what is ending condition base-case
      // chose one option and recurse 
      // undo the choice anmd try next option 

      // digits size == list.get(i)
    //   base
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        String letters = phonebook.get(digits.charAt(index));

        for(char ch:letters.toCharArray()){
            current.append(ch);
             backtrackCom(digits, index + 1, phonebook, current, result);
            current.deleteCharAt(current.length() - 1);
        }
      
      


    }

    // ----------------------------------------------------------------------------------------
    public List<List<Integer>> combinationSum3(int k, int n) {

        //leetcode-216. Combination Sum III
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<>() ,1, k,n);
        return result;
    }

    private static void backtrack(List<List<Integer>> result , List<Integer> temp ,int start,  int k , int target ){
        
        //calculating sum
        int sum = 0;
        for(int num: temp) sum += num;


        //valid combination

        if(temp.size()==  k && sum == target){
            result.add(new ArrayList<>(temp));
        }
        if(temp.size()>=  k || sum > target){
            return;
        }

        // backtrack from 1 to 9
        for(int i = start ;i<10;i++){
            temp.add(i);
            backtrack(result,temp , i+1,k , target);
            temp.remove(temp.size()-1);
        }
    }
    //------------------------------------------------------------------------------------

     public int combinationSum4(int[] nums, int target) {
        //leetcode-377 Combination sum IV
        Integer[] memo = new Integer[target + 1];
        return helper(nums, target, memo);
    }

    int helper(int[] nums, int target, Integer[] memo) {
        if (target == 0) return 1; // Found a valid combination
        if (target < 0) return 0;  // Invalid path
        if (memo[target] != null) return memo[target]; // Return cached result

        int count = 0;
        for (int num : nums) {
            count += helper(nums, target - num, memo); // Try including each number
        }
        memo[target] = count; // Store result
        return count;
    }

    //-------------------------------------------------------------------------------------
}
