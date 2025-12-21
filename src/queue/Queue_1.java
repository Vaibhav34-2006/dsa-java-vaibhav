package queue;

public class Queue_1 {

    // Inner static Queue class
    static class Queue {
        static int arr[];   // array to store queue elements
        static int size;    // maximum size of queue
        static int rear;    // points to last element

        // Constructor
        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;     // queue initially empty
        }

        // Check if queue is empty
        public static boolean isEmpty() {
            return rear == -1;
        }

        // Add (enqueue) element
        public static void add(int data) {
            // Check overflow
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }

            rear = rear + 1;
            arr[rear] = data;
        }

        // Remove (dequeue) element
        public static int remove() {
            // Check underflow
            if (isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }

            int front = arr[0];

            // Shift elements to the left
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }

            rear--; // reduce size
            return front;
        }

        // Peek (get front element)
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }

            return arr[0];
        }
    }

    // Main method
    public static void main(String[] args) {

        Queue q = new Queue(5);

        q.add(1);
        q.add(2);
        q.add(3);

        // Print and remove all elements
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
