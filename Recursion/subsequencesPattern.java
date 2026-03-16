package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class subsequencesPattern {

    public List<String> generateParenthesis(int n){
        // leetcode : 22 generate parenthesis 

        List<String> result = new ArrayList<>();
        generate("",n,result);
        return result;
    }
    public void generate(String current, int n , List<String> result){
        //leetcode : 22 generate parenthesis 
        if (current.length()==2*n) {
            if(isValidParenthesis(current)) result.add(current);
            return;
        }
        generate(current+"(" , n, result);
        generate(current+")" , n, result);
    }
    public boolean isValidParenthesis(String s){

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } 
            else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target)   {
        // leetcode:39 combination sum 
        // brute force :
        // this is a dfs question :---
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0,candidates , target , new ArrayList<>(), result);
        return result;
    }
    public void backtrack(int index, int[] candidates, int target, List<Integer> current, List<List<Integer>> result){

        if (target==0) {
            result.add(new ArrayList<>(current));
        }
        if (target<0) {
            return ;
        }
        for(int i = index;i<candidates.length;i++){
            current.add(candidates[i]);

            backtrack(i, candidates, target - candidates[i], current, result);
            current.remove(current.size() - 1);
        }
    }
    public static void main(String[] args) {
        subsequencesPattern obj = new subsequencesPattern();
        int n = 3;
        System.out.println("The total parennthesis is : "+obj.generateParenthesis(n));
        
    }
}