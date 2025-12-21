package queue;

import java.util.*;

public class Queue_9 {

    // Method to reverse a Queue using Stack
    public static void reverse(Queue<Integer> q) {

        // Create a stack to help in reversing
        Stack<Integer> s = new Stack<>();

        // Step 1: Remove elements from queue and push into stack
        // Queue -> Stack
        while (!q.isEmpty()) {
            s.push(q.remove());   // remove() deletes front element of queue
        }

        // Step 2: Pop elements from stack and add back to queue
        // Stack -> Queue (reversed order)
        while (!s.isEmpty()) {
            q.add(s.pop());       // pop() removes top element of stack
        }
    }

    public static void main(String[] args) {

        // Create Queue using LinkedList
        Queue<Integer> q = new LinkedList<>();

        // Add elements to queue
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        // Reverse the queue
        reverse(q);

        // Print reversed queue
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }
}
