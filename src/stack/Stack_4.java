package stack;
import java.util.*;

public class Stack_4 {

    // This method inserts an element at the bottom of the stack
    public static void pushatbottom(Stack<Integer> s, int data) {

        // Base case: if stack is empty, push the data and return
        if (s.isEmpty()) {
            s.push(data);
            return;
        }

        // Remove the top element
        int top = s.pop();

        // Recursive call to reach the bottom of the stack
        pushatbottom(s, data);

        // Push the stored elements back after inserting at bottom
        s.push(top);
    }

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

            // Print the top element of the stack
            System.out.println(s.peek());

            // Remove the top element from the stack
            s.pop();
        }
    }
}
