package String;

import java.util.Stack;

public class StringEasy {

    public boolean isValid(String s) {
        // leetcode 20:
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
            
            if (ch=='(' || ch =='{' ||ch=='[') {
                stack.push(ch);
            }else{
                if(stack.isEmpty()) return false;

                char top = stack.peek();
                if((ch==')' && top =='(')||
                (ch=='}' && top =='{')||
                (ch==']' && top =='[')){
                    stack.pop();
                }else{
                    return false;
                }
            }

        }
        System.out.println(stack);

        return (stack.size()==0);
    }

    public static void main(String[] args) {
        StringEasy obj = new StringEasy();
        String parenthesis = "{}{}{}";

        System.out.println("Is this string valid " + obj.isValid(parenthesis));
    }
}
