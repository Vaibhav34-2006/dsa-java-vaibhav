package queue;

public class Queue_3 {

    // Node class for Linked List
    static class Node {
        int data;       // value stored in node
        Node next;      // reference to next node

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Queue class
    static class Queue {
        static Node head = null;   // front of queue
        static Node tail = null;   // rear of queue

        // Check if queue is empty
        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        // Add (enqueue) element
        public static void add(int data) {
            Node newNode = new Node(data);

            // If queue is empty
            if (head == null) {
                head = tail = newNode;
                return;
            }

            // Add at the end
            tail.next = newNode;
            tail = newNode;
        }

        // Remove (dequeue) element
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }

            int front = head.data;

            // Single element case
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
            }

            return front;
        }

        // Peek front element
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }

            return head.data;
        }
    }

    // Main method
    public static void main(String[] args) {

        Queue.add(1);
        Queue.add(2);
        Queue.add(3);

        while (!Queue.isEmpty()) {
            System.out.println(Queue.peek());
            Queue.remove();
        }
    }
}
