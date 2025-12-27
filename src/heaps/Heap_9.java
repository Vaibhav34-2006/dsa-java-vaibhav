package heaps;

import java.util.PriorityQueue;

public class Heap_9 {

    public static void main(String[] args) {

        // Given rope lengths
        int ropes[] = {2, 3, 3, 4, 6};

        // Min Heap to always pick the smallest ropes
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all ropes into min heap
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }

        int cost = 0;

        // Continue until only one rope remains
        while (pq.size() > 1) {

            // Take two smallest ropes
            int min1 = pq.remove();
            int min2 = pq.remove();

            // Cost to connect them
            int sum = min1 + min2;
            cost += sum;

            // Add the combined rope back
            pq.add(sum);
        }

        // Final minimum cost
        System.out.println("Cost of connecting n ropes = " + cost);
    }
}
