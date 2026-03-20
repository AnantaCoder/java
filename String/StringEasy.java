package String;

import java.util.Stack;

public class StringEasy {

    public boolean isValid(String s) {
        // leetcode-20:
        /*
         * Given a string s containing just the characters '(', ')', '{', '}', '[' and
         * ']', determine if the input string is valid.
         * 
         * An input string is valid if:
         * 
         * Open brackets must be closed by the same type of brackets.
         * Open brackets must be closed in the correct order.
         * Every close bracket has a corresponding open bracket of the same type.
         */
        // its a stack problem so we need to push and pop the element .
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty())
                    return false;

                char top = stack.peek();
                if ((ch == ')' && top == '(') ||
                        (ch == '}' && top == '{') ||
                        (ch == ']' && top == '[')) {
                    stack.pop();
                } else {
                    return false;
                }
            }

        }
        System.out.println(stack);

        return (stack.size() == 0);
    }

    public boolean isPalindrome(String s) {
        // leetcode-125 :
        // cleaning non optimal way
        /*
         * String cleaned = s.trim();
         * cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
         * StringBuilder ss = new StringBuilder(cleaned);
         * String reversed = ss.reverse().toString();
         * return cleaned.equals(reversed);
         */

        // optimal way O(n)
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(right) != s.charAt(left)) {
                return false;
            }
            left++;
            right--;
        }
        return true;

    }

    public boolean isPalindromeOptimised(String s) {
        // leetcode-125

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            while (left < right && !isAlphaNumaric(s.charAt(left))) {
                left++;
            }
            while (left < right && !isAlphaNumaric(s.charAt(right))) {
                right--;
            }
            char l = toLower(s.charAt(left));
            char r = toLower(s.charAt(right));

            if(l!=r) return false;
            right--;
            left++;

        }
        return true;
    }
    private static boolean isAlphaNumaric(char ch) {

        if (ch >= 'a' && ch <= 'z') {
            return true;
        }
        if (ch >= 'A' && ch <= 'Z') {
            return true;
        }
        if (ch >= '0' && ch <= '9') {
            return true;
        }
        return false;
    }
    private static char toLower(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c + 32); // ASCII trick
        }
        return c;
    }

    public void reverseString(char[] s ){
        //Reverse String : leetcode-344 
        int left = 0;
        int right = s.length  -1 ;

        while (left<right) {
            char temp = s[left];
            s[left]            = s[right];
            s[right]=temp;
            left++;
            right--;
        }
    }

    public String mergeAlternately(String word1, String word2) {
        // leetcode-1768
        /* leetcode75 */

        //  we need to alternatively merge two strings 
        // first clean them then run a loop and then add them in a string buffer . 
        // two pointer approach in this
        
        // PS:alternatively we can use charecter arrays with new combined length to improve the runtime . 
        StringBuffer sb = new StringBuffer();
        int i = 0 ; 
        int j =0 ;
        int w1length = word1.length();
        int w2length = word2.length();

        while (i<w1length && j<w2length) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));
            i++;
            j++;
        }
        // append the remaining edge case 
        while (i<w1length) {
            sb.append(word1.charAt(i));
            i++;
        }
        while (j<w2length) {
            sb.append(word2.charAt(j));
            j++;
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        StringEasy obj = new StringEasy();
        String parenthesis = "{}{}{}";
        String s = "A man, a plan, a canal: Panama";
        String word1 = "abc";
        String word2 = "pqrsef";
        // System.out.println("Is this string valid " + obj.isValid(parenthesis));
        // System.out.println("Is this string Palindrome : " + obj.isPalindromeOptimised(s));
        System.out.println("Merfing 2 words alternatively  : " + obj.mergeAlternately(word1, word2));
        


    }
}
