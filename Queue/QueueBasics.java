import java.util.Stack;

import Recursion.subsequencesPattern;

public class QueueBasics {



    //leetcode-232 Implimenting Queue using stack
   private Stack<Integer> inStack; // handles incomiong element 
    private Stack<Integer> outStack; // handles outgoing elemtnt

    public QueueBasics() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        if (outStack.isEmpty()) {
            move();
        }
        return outStack.pop();
    }
    
    public int peek() {
        if (outStack.isEmpty()) {
            move();
        }
        return outStack.peek();
    }
    
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    /**
     * Helper function to move elements from inStack to outStack
     * This reverses the order to simulate queue behavior
     */
    private void move() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop()); // the elemt that removed after the pop 
        }
    }
}
