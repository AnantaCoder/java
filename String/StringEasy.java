package String;

import java.util.*;

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

            if (l != r)
                return false;
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

    public void reverseString(char[] s) {
        // Reverse String : leetcode-344
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public String mergeAlternately(String word1, String word2) {
        // leetcode-1768
        /* leetcode75-1 */

        // we need to alternatively merge two strings
        // first clean them then run a loop and then add them in a string buffer .
        // two pointer approach in this

        // PS:alternatively we can use charecter arrays with new combined length to
        // improve the runtime .
        StringBuffer sb = new StringBuffer();
        int i = 0;
        int j = 0;
        int w1length = word1.length();
        int w2length = word2.length();

        while (i < w1length && j < w2length) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));
            i++;
            j++;
        }
        // append the remaining edge case
        while (i < w1length) {
            sb.append(word1.charAt(i));
            i++;
        }
        while (j < w2length) {
            sb.append(word2.charAt(j));
            j++;
        }

        return sb.toString();
    }

    public String gcdOfStrings(String str1, String str2) {
        // leetcode-1071. Greatest Common Divisor of Strings
        /* leetcode75-2 */
        // Step 1: Check validity
        if (!(str1 + str2).equals(str2 + str1)) {
            return "No Substring Present";
        }

        // Step 2: Find GCD of lengths
        int a = str1.length();
        int b = str2.length();

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        // Step 3: Return substring
        return str1.substring(0, a);
    }

    public int minEatingSpeed(int[] piles, int h) {
        int high = 1;
        int low = 1;

        for (int i : piles) {
            high = Math.max(high, i);
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long totalHours = 0;

            for (int i : piles) {
                totalHours += (i + mid - 1) / mid; // ceil division
            }

            if (totalHours <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public String reverseVowels(String s) {
        // leetcode-345 Reverse vowels of a string
        /* leetcode75-5 */
        // all vowels a,e,i,o,u
        // IceCreAm -> vowels[0]I,vowels[2]e,vowels[5]e,vowels[6]A =>rev=> AceCreIm
        HashMap<Integer, Character> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
                    || ch == 'O' || ch == 'U') {
                map.put(i, ch);
            }
        }
        // reverse values
        List<Character> list = new ArrayList<>(map.values());
        Collections.reverse(list);

        // put back into string
        char[] charArray = s.toCharArray();
        int index = 0;

        for (int key : map.keySet()) {
            charArray[key] = list.get(index++);
        }

        return new String(charArray);

        // ps: this is not an optimal we can use two poiunter approach as well .

    }

    public String reverseVowelsPointerApproach(String s) {

        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            // forward until vowel
            while (left < right && !isVowel(arr[left])) {
                left++;
            }
            // backword until vowel
            while (left < right && !isVowel(arr[right])) {
                right--;
            }
            // swap
            char t = arr[left];
            arr[left] = arr[right];
            arr[right] = t;
            left++;
            right--;
        }

        return new String(arr);
    }

    private static boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
                || ch == 'O' || ch == 'U') {
            return true;
        }
        return false;
    }

    public boolean isSubsequence(String s, String t) {
        // leetcode-392 is Sub seqquence
        /* leetcode75-11 */

        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    public String reverseStr(String s, int k) {
        //leetcode-541. Reverse String II 
        char[] str = s.toCharArray();
        int len  = str.length;

       for (int l = 0; l < len; l+=2*k) {
           int left = l;
           int right = Math.min(l+k-1,len-1);
           reversePartsOfStrings(str, left, right);
       }
       return new String(str);

    }
    private void reversePartsOfStrings(char[] s,int left,int right){
        // this is to reverse the entire string 

        while(left<right){
            char t = s[right];
            s[right] = s[left];
            s[left]=t;
            left++;
            right--;

        }
    }
    public int firstUniqChar(String s) {
        // leetcode-387 first unique charecter in string
       
        int[] freq = new int[26];
        for (int i : s.toCharArray()) {
            freq[i-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i)-'a']==1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StringEasy obj = new StringEasy();
        String parenthesis = "{}{}{}";
        String s = "A man, a plan, a canal: Panama";
        String word1 = "abc";
        String word2 = "pqrsef";
        String str1 = "abcabc";
        String str2 = "ab";
        String strReverse = "IceCreAm";
        int[] piles = new int[] { 3, 6, 7, 11 };
        int h = 8;
        System.out.println("Is this string valid " + obj.isValid(parenthesis));
        System.out.println("Is this string Palindrome : " + obj.isPalindromeOptimised(s));
        System.out.println("Merfing 2 words alternatively  : " + obj.mergeAlternately(word1, word2));
        System.out.println("gcd of the string is   : " + obj.gcdOfStrings(str1, str2));
        System.out.println("Coco eats bananas    : " + obj.minEatingSpeed(piles, h));
        System.out.println("Coco eats bananas    : " + obj.minEatingSpeed(piles, h));
        System.out.println("Reverse Vowels in the string  : " + obj.reverseVowelsPointerApproach(strReverse));

    }
}
