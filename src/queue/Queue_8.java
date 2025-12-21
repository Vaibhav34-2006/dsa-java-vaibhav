package queue;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_8 {

    // Method to interleave the first half of the queue with the second half
    public static void interLeave(Queue<Integer> q) {

        // Queue to store the first half elements
        Queue<Integer> firstHalf = new LinkedList<>();

        int size = q.size();

        // Step 1: Move first half elements from q to firstHalf
        for (int i = 0; i < size / 2; i++) {
            firstHalf.add(q.remove());
        }

        // Step 2: Interleave elements from firstHalf and remaining q
        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove()); // add from first half
            q.add(q.remove());         // add from second half
        }
    }

    public static void main(String[] args) {

        // Create queue
        Queue<Integer> q = new LinkedList<>();

        // Add elements
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        // Interleave the queue
        interLeave(q);

        // Print the interleaved queue
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }
}
