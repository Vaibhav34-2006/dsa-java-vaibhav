package queue;

import java.util.Deque;
import java.util.LinkedList;

public class Queue_12 {

    // Static inner Queue class
    static class Queue {

        // Deque used to implement Queue (FIFO)
        Deque<Integer> deque = new LinkedList<>();

        // Add element at the rear of the queue
        public void add(int data) {
            deque.addLast(data); // enqueue operation
        }

        // Remove element from the front of the queue
        public int remove() {
            return deque.removeFirst(); // dequeue operation
        }

        // Get front element without removing it
        public int peek() {
            return deque.getFirst(); // front element
        }
    }

    public static void main(String[] args) {

        // Create Queue object
        Queue q = new Queue();

        // Add elements to queue
        q.add(1);
        q.add(2);
        q.add(3);

        // Peek front element
        System.out.println("peek = " + q.peek());

        // Remove elements one by one (FIFO order)
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}
