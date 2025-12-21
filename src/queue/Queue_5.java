package queue;

import java.util.Stack;

public class Queue_5 {

    // Queue implemented using two stacks
    static class Queue {
        static Stack<Integer> s1 = new Stack<>(); // main stack
        static Stack<Integer> s2 = new Stack<>(); // helper stack

        // Check if queue is empty
        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        // Add (enqueue) element - COSTLY ADD
        public static void add(int data) {

            // Move all elements from s1 to s2
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            // Push new element into s1
            s1.push(data);

            // Move everything back to s1
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        // Remove (dequeue) element
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue empty");
                return -1;
            }

            return s1.pop();
        }

        // Peek front element
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue empty");
                return -1;
            }

            return s1.peek(); // FIXED (no pop here)
        }
    }

    // Main method
    public static void main(String[] args) {

        Queue q = new Queue();

        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
