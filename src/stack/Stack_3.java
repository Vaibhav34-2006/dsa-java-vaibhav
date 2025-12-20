package stack;

import java.util.*;   // Import Stack class

public class Stack_3 {

    public static void main(String[] args) {

        // Create a stack of Integer type (Java built-in Stack)
        Stack<Integer> s = new Stack<>();

        // Push elements into stack
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        // Pop and print elements until stack is empty
        while (!s.isEmpty()) {

            // Print top element of stack
            System.out.println(s.peek());

            // Remove top element from stack
            s.pop();
        }
    }
}
