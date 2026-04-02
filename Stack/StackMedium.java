package Stack;

import java.util.Stack;

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
        /* leetcode75-stack-1 */
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

    public static void main(String[] args) {
        StackMedium sm = new StackMedium();

        // Test removeStars
        System.out.println("=== removeStars ===");
        System.out.println(sm.removeStars("leet**cod*e")); // expected: "lecoe"
        System.out.println(sm.removeStars("erase*****")); // expected: ""

        // Test asteroidCollision
        System.out.println("=== asteroidCollision ===");
        System.out.println(java.util.Arrays.toString(sm.asteroidCollision(new int[] { 5, 10, -5 }))); // [5, 10]
        System.out.println(java.util.Arrays.toString(sm.asteroidCollision(new int[] { 8, -8 }))); // []
        System.out.println(java.util.Arrays.toString(sm.asteroidCollision(new int[] { 10, 2, -5 }))); // [10]
        System.out.println(java.util.Arrays.toString(sm.asteroidCollision(new int[] { -2, -1, 1, 2 }))); // [-2, -1, 1,
                                                                                                         // 2]
    }

}
