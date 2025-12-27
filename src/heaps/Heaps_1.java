package heaps;

import java.util.PriorityQueue;

public class Heaps_1 {

    public static void main(String[] args) {

        // PriorityQueue in Java works as a MIN-HEAP by default
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Inserting elements into the heap
        // Time Complexity: O(log n) for each add
        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(7);

        // Removing elements from heap in sorted (ascending) order
        while (!pq.isEmpty()) {

            // peek() returns the smallest element
            // Time Complexity: O(1)
            System.out.println(pq.peek());

            // remove() deletes the smallest element
            // Time Complexity: O(log n)
            pq.remove();
        }
    }
}
