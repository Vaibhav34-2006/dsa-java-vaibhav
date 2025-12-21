package queue;

import java.util.Queue;
import java.util.ArrayDeque;
// import java.util.LinkedList;

public class Queue_4 {

    public static void main(String[] args) {

        // Queue using Java Collection Framework
        // LinkedList can also be used, but ArrayDeque is faster
        Queue<Integer> q = new ArrayDeque<>();

        // Add elements (enqueue)
        q.add(1);
        q.add(2);
        q.add(3);

        // Print and remove elements (FIFO)
        while (!q.isEmpty()) {
            System.out.println(q.peek()); // front element
            q.remove();                   // remove front
        }
    }
}
