package queue;

import java.util.Deque;
import java.util.LinkedList;

public class Queue_10 {

    public static void main(String[] args) {

        // Create a Deque using LinkedList
        // Deque allows insertion and deletion from both ends
        Deque<Integer> deque = new LinkedList<>();

        // Add elements at the front of the deque
        deque.addFirst(1);   // Deque: [1]
        deque.addFirst(2);   // Deque: [2, 1]

        // Add elements at the end of the deque
        deque.addLast(3);    // Deque: [2, 1, 3]
        deque.addLast(4);    // Deque: [2, 1, 3, 4]

        // Print the deque
        System.out.println(deque);

        // Remove the last element from the deque
        deque.removeLast();  // Removes 4 → Deque becomes [2, 1, 3]

        // Print deque after removal
        System.out.println(deque);

        // Get and print the first element
        System.out.println("first el = " + deque.getFirst());

        // Get and print the last element
        System.out.println("last el = " + deque.getLast());
    }
}
