package Stack;

import java.util.Stack;

import Recursion.subsequencesPattern;

public class StackMedium {
    public String removeStars(String s) {

        // leetcode-2390. Removing Stars From a String
        /* leetcode75-stack-1 */
        Stack<Character> stack = new Stack<>();

        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {

            if (str[i] != '*') {
                stack.push(str[i]);
            } else if (str[i] == '*') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }

    public int[] asteroidCollision(int[] asteroids) {
        // leetcode-735 Astroid collisions using stack
        /* leetcode75-stack-2 */
        // stack is first in last out
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {

            boolean destroyed = false;

            while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {
                if (stack.peek() < -ast) {
                    stack.pop();
                } else if (stack.peek() == -ast) {
                    stack.pop();
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(ast);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;

    }

    public String decodeString(String s) {
        // leetcode-394 decoding string
        /* leetcode75-stack-3 */

        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        String currentString = "";
        int num = 0;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            else if (ch == '[') {
                countStack.push(num);
                stringStack.push(currentString);
                num = 0;
                currentString = "";
            } else if (ch == ']') {
                int repeat = countStack.pop();
                String prev = stringStack.pop();

                StringBuilder temp = new StringBuilder(prev);
                for (int i = 0; i < repeat; i++) {
                    temp.append(currentString);
                }
                currentString = temp.toString();
            }
            else{
                currentString += ch;
            }
        }
        return currentString;
    }

    public static void main(String[] args) {
        StackMedium sm = new StackMedium();

        // // Test removeStars
        // System.out.println("=== removeStars ===");
        // System.out.println(sm.removeStars("leet**cod*e")); // expected: "lecoe"
        // System.out.println(sm.removeStars("erase*****")); // expected: ""

        // // Test asteroidCollision
        // System.out.println("=== asteroidCollision ===");
        // System.out.println(java.util.Arrays.toString(sm.asteroidCollision(new int[] {
        // 5, 10, -5 }))); // [5, 10]
        // System.out.println(java.util.Arrays.toString(sm.asteroidCollision(new int[] {
        // 8, -8 }))); // []
        // System.out.println(java.util.Arrays.toString(sm.asteroidCollision(new int[] {
        // 10, 2, -5 }))); // [10]
        // System.out.println(java.util.Arrays.toString(sm.asteroidCollision(new int[] {
        // -2, -1, 1, 2 }))); // [-2, -1, 1,

        // decoding the strings
        String s = "3[a]2[bc]";
        System.out.println("decoded string is " + sm.decodeString(s));
        // 2]
    }

}
