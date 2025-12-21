package queue;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_6 {

    // Stack implemented using two Queues
    static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        // Check if stack is empty
        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        // Push element into stack (O(1))
        public static void push(int data) {
            // Always push into non-empty queue
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        // Pop element from stack (COSTLY POP)
        public static int pop() {
            if (isEmpty()) {
                System.out.println("Empty stack");
                return -1;
            }

            int top = -1;

            // Case 1: q1 has elements
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break; // last element (stack top)
                    }
                    q2.add(top);
                }
            }
            // Case 2: q2 has elements
            else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        // Peek top element (COSTLY PEEK)
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty stack");
                return -1;
            }

            int top = -1;

            // Case 1: q1 has elements
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            }
            // Case 2: q2 has elements
            else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }

    // Main method
    public static void main(String[] args) {

        Stack s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
