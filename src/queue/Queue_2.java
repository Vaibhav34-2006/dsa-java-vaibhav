package queue;

public class Queue_2 {

    // Static inner Queue class
    static class Queue {
        static int arr[];     // array to store queue elements
        static int size;      // maximum size of queue
        static int rear;      // index of last element
        static int front;     // index of first element

        // Constructor
        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;        // queue initially empty
            front = -1;
        }

        // Check if queue is empty
        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        // Check if queue is full (circular condition)
        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        // Add (enqueue) element
        public static void add(int data) {
            // Overflow condition
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }

            // If first element is added
            if (front == -1) {
                front = 0;
            }

            // Circular increment
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // Remove (dequeue) element
        public static int remove() {
            // Underflow condition
            if (isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }

            int result = arr[front];

            // If last element is removed
            if (rear == front) {
                rear = front = -1;
            } else {
                // Circular increment
                front = (front + 1) % size;
            }

            return result;
        }

        // Peek (get front element)
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }

            return arr[front];
        }
    }

    // Main method
    public static void main(String[] args) {

        Queue q = new Queue(3);

        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println(q.remove()); // 1
        q.add(4);
        System.out.println(q.remove()); // 2
        System.out.println(q.remove()); // 3
        System.out.println(q.remove()); // 4
    }
}
