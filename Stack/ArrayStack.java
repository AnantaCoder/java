package Stack;

import java.util.Scanner;

public class ArrayStack {

    private int[] stackArray;
    private int capacity;
    private int topIndex;

    public ArrayStack(int size) {
        this.capacity = size;
        this.stackArray = new int[capacity];
        this.topIndex = -1;
    }

    public ArrayStack() {
        this(1000);
    }

    // push: adds x on top of the stack by incrementing topIndex first, then storing
    // x
    public void push(int x) {
        if (topIndex >= capacity - 1) {
            System.out.println("Stack overflow");
            return;
        }
        stackArray[++topIndex] = x;
    }

    // pop: removes the top element by decrementing topIndex (no actual deletion
    // needed)
    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        topIndex--;
    }

    // top: returns the element at topIndex without removing it
    public int top() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stackArray[topIndex];
    }

    // isEmpty: stack is empty when topIndex is -1 (no elements pushed yet)
    public boolean isEmpty() {
        return topIndex == -1;
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("ArrayStack Menu:");
        System.out.println("1. Push");
        System.out.println("2. Pop");
        System.out.println("3. Top");
        System.out.println("4. isEmpty");
        System.out.println("5. Exit");

        while (running) {
            System.out.print("\nEnter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int val = scanner.nextInt();
                    stack.push(val);
                    System.out.println("Pushed: " + val);
                    break;
                case 2:
                    stack.pop();
                    System.out.println("Popped top element");
                    break;
                case 3:
                    System.out.println("Top: " + stack.top());
                    break;
                case 4:
                    System.out.println("isEmpty: " + stack.isEmpty());
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, try 1-5");
            }
        }
        scanner.close();
    }
}
