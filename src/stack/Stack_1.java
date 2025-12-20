package stack;              // Package name

import java.util.*;         // Import utility classes (ArrayList)

public class Stack_1 {

    // ArrayList used to implement Stack
    // 'static' because methods are static
    static ArrayList<Integer> list = new ArrayList<>();

    // Method to check whether stack is empty
    public static boolean isEmpty() {
        // If size is 0, stack is empty
        return list.size() == 0;
    }

    // PUSH operation
    // Adds element at the top of stack
    public static void push(int data) {
        list.add(data);     // Add element at end
    }

    // POP operation
    // Removes and returns top element
    public static int pop() {
        // If stack is empty, return -1
        if (isEmpty()) {
            return -1;
        }

        // Get top element
        int top = list.get(list.size() - 1);

        // Remove top element
        list.remove(list.size() - 1);

        // Return removed element
        return top;
    }

    // PEEK operation
    // Returns top element without removing it
    public static int peek() {
        // If stack is empty, return -1
        if (isEmpty()) {
            return -1;
        }

        // Return top element
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {

        // Push elements into stack
        Stack_1.push(1);
        Stack_1.push(2);
        Stack_1.push(3);
        Stack_1.push(4);
        Stack_1.push(5);

        // Pop and print elements until stack is empty
        while (!Stack_1.isEmpty()) {
            System.out.println(Stack_1.peek()); // Print top element
            Stack_1.pop();                      // Remove top element
        }
    }
}
