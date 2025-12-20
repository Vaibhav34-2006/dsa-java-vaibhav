package stack;

import java.util.Stack;

public class Stack_6 {

    // Function to push an element at the bottom of the stack
    public static void pushAtBottom(Stack<Integer> s, int data) {

        // Base case: if stack is empty, push the data
        if (s.isEmpty()) {
            s.push(data);
            return;
        }

        // Remove the top element
        int top = s.pop();

        // Recursive call to reach the bottom
        pushAtBottom(s, data);

        // Push the stored element back
        s.push(top);
    }

    // Function to reverse the stack using recursion
    public static void reverseStack(Stack<Integer> s) {

        // Base case: if stack is empty, return
        if (s.isEmpty()) {
            return;
        }

        // Pop the top element
        int top = s.pop();

        // Reverse the remaining stack
        reverseStack(s);

        // Push the popped element at the bottom
        pushAtBottom(s, top);
    }

    // Function to print stack elements
    public static void printStack(Stack<Integer> s) {

        // Print and remove elements until stack becomes empty
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static void main(String[] args) {

        // Create a stack
        Stack<Integer> s = new Stack<>();

        // Push elements into the stack
        s.push(1);
        s.push(2);
        s.push(3);

        // Reverse the stack
        reverseStack(s);

        // Print reversed stack
        printStack(s);
    }
}
